package newPack.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int maxTries = 2;
	int currTry=0;
	@Override
	public boolean retry(ITestResult result) {
		if(currTry<maxTries) {
			currTry++;
			return true;
		}
		return false;
	}

}
