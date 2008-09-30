package templatetools;

import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.ui.PlatformUI;

public class ClipboardVariableResolver extends TemplateVariableResolver {

	protected String resolve(TemplateContext context) {
		Clipboard clipboard = new Clipboard(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell().getDisplay());
		Object content = clipboard.getContents(TextTransfer.getInstance());
		if (content != null) {
			return (String) content;
		}
		return getType();
	}

}
