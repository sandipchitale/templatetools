package templatetools;

import java.util.List;

import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.PlatformUI;

import templatetools.api.IPrompt;

public class DirectoryPrompt implements IPrompt {

	@SuppressWarnings("unchecked")
	public String getValue(String name, List params) {
		DirectoryDialog directoryDialog = new DirectoryDialog(PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getShell());
		directoryDialog.setText("Select dircetory for '" + name + "'");
		return directoryDialog.open();
	}

}
