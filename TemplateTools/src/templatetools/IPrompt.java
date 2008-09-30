package templatetools;

import java.util.List;

public interface IPrompt {
	@SuppressWarnings("unchecked")
	String getValue(String name, List params);
}
