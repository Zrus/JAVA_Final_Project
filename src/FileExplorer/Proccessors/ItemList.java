package FileExplorer.Proccessors;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemList {
    File[] items;

    ItemList() {
        items = File.listRoots();
    }
}
