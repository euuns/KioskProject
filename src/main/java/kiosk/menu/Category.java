package kiosk.menu;

import kiosk.product.MenuItem;

public interface Category {
    void printCategoryMenu();
    int categorySize();
    MenuItem getChoice(int idx);
    String getCategoryName();
    void setCategoryName();
}
