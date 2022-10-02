package test_file;

import adt_reto0.classes.Customer;
import org.junit.Assert.*;
import adt_reto0.dataAccess.FileDACustomer;
import java.io.File;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestFileCustomer {
	private File normalData = new File("bankrecords.dat");
	private File backupData = new File("bankrecords.dat.backup");
        private static FileDACustomer fdac;

	/**
	* Rename the records file to do tests
	* with a clean file without removing
	* the old one
	*/
	@Before
	public void setUp() {
		normalData.renameTo(backupData);
		fdac.createCustomer(1, "Nicolas", "Rodriguez", "B", "Sq", "Bilbao", "California", "a@b.com", 48002, 666666666);
	}

	@Test
	public void testCreateCustomer() {
		assertEquals((Integer)1,
			fdac.getCustomerData(1)
				.getId()
			);
	}

    @Test
    public void testGetCustomerData() {
            Customer testCustomer=null;
        assertEquals(0, fdac.getCustomerData(1).compareTo(testCustomer));
    }
	
	@Test
	public void testGetCustomerAccounts() {
		//TODO
	}
	
	/**
	* Delete the test file and undo
	* the renaming operation done in
	* the setUp function
	*/
	@After
	public void tearDown() {
		normalData.delete();
		backupData.renameTo(normalData);
	}

}
