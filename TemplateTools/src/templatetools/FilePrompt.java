package templatetools;

import java.util.List;

import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

public class FilePrompt implements IPrompt {

	@SuppressWarnings("unchecked")
	public String getValue(String name, List params) {
		FileDialog fileDialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
		fileDialog.setText("Select file for '" + name + "'");
		return fileDialog.open();
	}

}
