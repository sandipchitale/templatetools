This plug-in enhances the functionality of code templates:

  * ${clipboard} template variable - replaced by the contents of the clipboard.
  * ${prompt(input|file|directory|enumeration, value [, value]`*`)}

This plug-in also supports extension-point promptProviders. Here is an example:

```
   <extension
         point="TemplateTools.promptProviders">
      <promptProvider
            class="templatetools.InputPrompt"
            type="input">
      </promptProvider>
     :
     :
   </extension>
```

Here is the implementation:

```
package templatetools;

import java.util.List;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.PlatformUI;

public class InputPrompt implements IPrompt {

	@SuppressWarnings("unchecked")
	public String getValue(String name, List params) {
		InputDialog inputDialog = new InputDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Enter value",
				"Enter value for '" + name + "' : ",
				name,
				null);
		if (inputDialog.open() == InputDialog.OK) {
			return inputDialog.getValue();
		}
		return null;
	}

}
```