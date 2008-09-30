package templatetools;

import java.util.Formatter;
import java.util.List;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.ui.PlatformUI;

public class ColorPrompt implements IPrompt {

	@SuppressWarnings("unchecked")
	public String getValue(String name, List params) {
		ColorDialog colorDilaog = new ColorDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
		RGB color = colorDilaog.open();
		if (color != null) {
			if (params.size() > 0) {
				Object format = params.get(0);
				if (format instanceof String) {
					StringBuffer formatBuffer = new StringBuffer();
					new Formatter(formatBuffer).format((String) format,
							color.red, color.green, color.blue);
					return formatBuffer.toString();
				}
			} else {
				return color.toString();
			}
		}
		return null;
	}

}
