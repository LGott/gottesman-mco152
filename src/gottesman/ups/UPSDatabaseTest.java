package gottesman.ups;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {

		Package pkg = new Package("01010");
		Location loc = new Location(10, 10);

		UPSDatabase ups = new UPSDatabase();
		ups.addPackageToLocation(loc, pkg);

		Set<Package> pkgSet = new HashSet<Package>();

		pkgSet.add(pkg);

		Assert.assertEquals(loc, ups.getLocation(pkg));
		Assert.assertEquals(pkgSet, ups.getPackages(loc));

	}

	@Test
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {

		Package pkg = new Package("01010");
		Location loc = new Location(10, 10);
		Location updatedLoc = new Location(15, 15);
		UPSDatabase ups = new UPSDatabase();

		ups.addPackageToLocation(loc, pkg);

		ups.updatePackageLocation(pkg, updatedLoc);

		Set<Package> pkgSet = new HashSet<Package>();
		pkgSet.add(pkg);

		Assert.assertEquals(updatedLoc, ups.getLocation(pkg));
		Assert.assertEquals(pkgSet, ups.getPackages(updatedLoc));
		Assert.assertNotEquals(loc, ups.getLocation(pkg));
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {

		Location loc = new Location(40, 40);
		UPSDatabase ups = new UPSDatabase();

		HashSet<Package> empty = new HashSet<Package>();
		Assert.assertEquals(empty, ups.getPackages(loc));
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {

		Package pkg = new Package("456");
		UPSDatabase ups = new UPSDatabase();
		Assert.assertEquals(null, ups.getLocation(pkg));

	}

}
