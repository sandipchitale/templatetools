package templatetools;

import java.util.List;

import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.ui.PlatformUI;

import templatetools.api.IPrompt;

public class FontPrompt implements IPrompt {

	@SuppressWarnings("unchecked")
	public String getValue(String name, List params) {
		FontDialog fontDialog = new FontDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
		FontData fontData = fontDialog.open();
		if (fontData != null) {
			return fontData.toString();
		}
		return null;
	}

}
