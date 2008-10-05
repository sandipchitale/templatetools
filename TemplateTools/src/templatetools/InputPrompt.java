package templatetools;

import java.util.List;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.PlatformUI;

import templatetools.api.IPrompt;

public class InputPrompt implements IPrompt {

	@SuppressWarnings("unchecked")
	public String getValue(String name, List params) {
		InputDialog inputDialog = new InputDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), "Enter value",
				"Enter value for '" + name + "' : ", name, null);
		if (inputDialog.open() == InputDialog.OK) {
			return inputDialog.getValue();
		}
		return null;
	}

}
