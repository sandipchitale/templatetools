package templatetools;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;

public class PromptVariableResolver extends TemplateVariableResolver {
	private String value = null;

	private static final String EXTENSION_NAME = "promptProviders"; //$NON-NLS-1$
	private static final String EXTENSION_POINT = Activator.PLUGIN_ID
			+ "." + EXTENSION_NAME; //$NON-NLS-1$
	private static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	private static final String TYPE_ATTRIBUTE = "type"; //$NON-NLS-1$

	@SuppressWarnings("unchecked")
	@Override
	public void resolve(TemplateVariable variable, TemplateContext context) {		
		// Initialize the name
		String name = variable.getName();
		if (name == null) {
			name = variable.getType();
		}

		// Params
		List params = variable.getVariableType().getParams();
		if (params.size() > 0) {
			// Prompt type
			String firstParam = (String) params.get(0);

			// Let us look for extension of the prompt type
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(EXTENSION_POINT);
			for (IConfigurationElement element : elements) {
				// Get extension prompt type
				String type = element.getAttribute(TYPE_ATTRIBUTE);

				if (firstParam.equals(type)) {
					String className = element.getAttribute(CLASS_ATTRIBUTE);
					if (className != null) {
						Object client;
						try {
							client = element
									.createExecutableExtension(CLASS_ATTRIBUTE);
							if (client instanceof IPrompt) {
								value = ((IPrompt) client).getValue(name,
										(params.size() > 1 ? 
												params.subList(1, params.size())
												: Collections.EMPTY_LIST));
								break;
							}
						} catch (CoreException e) {
							Activator.getDefault().getLog().log(
									new Status(IStatus.ERROR,
											Activator.PLUGIN_ID,
											e.getMessage(), e));
						}
					}
				}
			}
		} else {
			value = new InputPrompt().getValue(name, Collections.EMPTY_LIST);
		}
		super.resolve(variable, context);
	}

	protected String resolve(TemplateContext context) {
		return (value == null ? getType() : value);
	}
}
