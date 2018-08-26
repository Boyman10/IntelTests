package algo;

import java.util.ArrayList;

/**
 * Binary search algorithm
 * Integer version
 * @see https://fr.wikipedia.org/wiki/Recherche_dichotomique
 */
public class BinarySearch {

    private ArrayList<Integer> refArray;

    /**
     * Constructor initializing the array list
     * @param array
     */
    public BinarySearch(ArrayList<Integer> array) {

        refArray = array;

    }

    public Integer recursiveSearch(int elt) {

        int index = this.refArray.size() / 2;
        int theElt = refArray.get(index);
        if (theElt == elt)
            return index;
        else if (theElt > elt) {
            refArray = (ArrayList<Integer>) refArray.subList(0, index);
            return recursiveSearch(elt);
        }
        else {
            refArray = (ArrayList<Integer>) refArray.subList(index, refArray.size());
            return recursiveSearch(elt);
        }
    }
}
