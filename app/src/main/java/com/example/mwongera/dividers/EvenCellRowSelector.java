package com.example.mwongera.dividers;

import com.karumi.dividers.Position;
import com.karumi.dividers.selector.AllItemsSelector;

/**
 * Created by mwongera on 3/22/16.
 */
public class EvenCellRowSelector extends AllItemsSelector {
    @Override
    public boolean isPositionSelected(Position position) {
        return position.getRow() % 2 == 0;
    }
}
