package templatetools;

import java.util.List;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class EnumerationPrompt implements IPrompt {

	@SuppressWarnings("unchecked")
	public String getValue(String name, List params) {
		ElementListSelectionDialog listDialog = new ElementListSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				new LabelProvider());
		listDialog.setTitle("Choose value of '" + name + "'");
		listDialog.setMultipleSelection(false);
		listDialog.setElements(params.toArray());
		if (listDialog.open() == InputDialog.OK) {
			return (String) listDialog.getFirstResult();
		}
		return null;
	}

}
