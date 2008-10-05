package templatetools.api;

import java.util.List;

public interface IPrompt {
	@SuppressWarnings("unchecked")
	String getValue(String name, List params);
}
