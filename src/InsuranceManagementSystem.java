import com.dkt.Automobile.Automobile;
import com.dkt.Automobile.Car;
import com.dkt.Automobile.Insurance;
import com.dkt.Automobile.InsuranceNotApplicableException;
import com.dkt.Automobile.Scooter;

public class InsuranceManagementSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Insurance ins = new Insurance();
		Automobile auto1 = new Car(5, 200000, 1200);
		try {
			System.out.println("Insurance cost of auto1 -- "
					+ ins.getCostOfInsurance(auto1));
		} catch (InsuranceNotApplicableException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getReason());
			e.printStackTrace();
		}

	}

}
