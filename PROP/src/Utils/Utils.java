/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rogia
 */
public class Utils {
    public static ArrayList cloneArrayList(ArrayList original) {
        ArrayList copy = new ArrayList (original.size());
        Collections.copy(copy, original);
        return copy;
    }
}
