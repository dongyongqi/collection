package exception_demo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChainTest {
	/**
	 * test1()抛出喝大异常
	 * test2()调用test1的异常
	 * @param args
	 */
public static void main(String[]args) {
		ChainTest cTest=new ChainTest();
		try {
			cTest.test2();
		} catch (Exception e) {
			e.printStackTrace();
			Date d=new Date();
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now=s.format(d);
			System.out.println(now);
		}
	}
public void test1()throws DrunkException{
	throw new DrunkException("和车别开酒");
		}
public void test2(){
	try {
		test1();
	} catch (DrunkException e) {
		// TODO Auto-generated catch block
		RuntimeException newExc=new RuntimeException(e);
		//newExc.initCause(e);
		throw newExc;
		
		}
	}
}
