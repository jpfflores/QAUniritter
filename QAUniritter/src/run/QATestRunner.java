package run;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import test.CadastroPageTest;
import test.CarrinhoPageTest;
import test.ContatoPageTest;
import test.FinalizaCompraPageTest;
import test.LoginPageTest;

public class QATestRunner {

	public static void main(String[] args) {
		  JUnitCore junit = new JUnitCore();
		  junit.addListener(new TextListener(System.out));
		  Result result = junit.run(LoginPageTest.class,CadastroPageTest.class, ContatoPageTest.class,CarrinhoPageTest.class,FinalizaCompraPageTest.class); 
		  if (result.getFailureCount() > 0) {
		    System.out.println("Test failed.");
		    System.exit(1);
		  } else {
		    System.out.println("Test finished successfully.");
		    System.exit(0);
		  }
	}

}
