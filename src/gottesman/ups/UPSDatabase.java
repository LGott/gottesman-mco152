package gottesman.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {

	HashMap<Package, Location> pkgLocMap;
	HashMap<Location, Set<Package>> locMap; // Hashmap to store all packages in specific location

	public UPSDatabase() {
		pkgLocMap = new HashMap<Package, Location>();
		locMap = new HashMap<Location, Set<Package>>();

	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {

		pkgLocMap.put(pkg, location); // Put the package and location in the map

		// If the locMap (for the set of packages) has the location,
		// then the package has to be added to that pkg set

		if (locMap.containsKey(location)) {

			Set<Package> packages = getPackages(location); // return the packages in the specified location into a set
			packages.add(pkg); // Add the pkg to the packages set
			locMap.put(location, packages); // put the location and set of packages for that location into the hashmap
		}

		// Otherwise, make a new set for that location and add the package
		else {
			Set<Package> packages = new HashSet<Package>();
			packages.add(pkg);
			locMap.put(location, packages);
		}

	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {

		if (pkgLocMap.containsKey(pkg)) {

			Location loc = getLocation(pkg); // Get the original location of the package using the getLocation method
			Set<Package> newSet = getPackages(loc); // Get the set of packages for the original location

			pkgLocMap.replace(pkg, location); // Replace the location in the pkg/location hashmap

			newSet.remove(pkg); // Remove the package from the old set
			locMap.put(loc, newSet); // Put the loc and the newSet into the locMap

			addPackageToLocation(location, pkg); // Call the addPackage method to re-update

		}

	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if the Location doesn't exist or there are no
	 *         Packages at that Location.
	 */
	public Set<Package> getPackages(Location location) {

		// if the map contains the location then return the set of packages for that location

		if (locMap.containsKey(location)) {
			return (locMap.get(location));
		}
		return new HashSet<Package>(); // Otherwise return an empty set

	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {

		if (pkgLocMap.containsKey(pkg)) { // If the pkg/loc map contains the pkg, return the location for that package
			// from the map

			return pkgLocMap.get(pkg);
		}
		return null;

	}

}
