package test_file;

import org.junit.Assert.*;
import adt_reto0.dataAccess.FileDACustomer;

public class TestFileCustomer {
	private File normalData = new File("bankrecords.dat");
	private File backupData = new File("bankrecords.dat.backup");

	/**
	* Rename the records file to do tests
	* with a clean file without removing
	* the old one
	*/
	@Before
	public void setUp() {
		normalData.renameTo(backupData);
		FileDACustomer.createCustomer(1, "Nicolas", "Rodriguez", "B", "Sq", "Bilbao", "California", "a@b.com", 48002, 666666666);
	}

	@Test
	public void testCreateCustomer() {
		assertEquals((Integer)1,
			FileDACustomer.getCustomerData(1)
				.getId()
			);
	}

    @Test
    public void testGetCustomerData() {
        assertEquals(0, FileDACustomer.getCustomerData(1).compareTo(testCustomer));
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
