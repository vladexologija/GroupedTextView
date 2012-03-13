# Android layout for grouping views together in iOS style

![GroupedTextView](http://2.bp.blogspot.com/-WjurFgw6PoI/T132MY1VDgI/AAAAAAAAAII/QfSt_vWR7eU/s400/groupedtableview.png "GroupedTextView")

This projects aims to provide grouping possibility for Android. 

The action bar component is an [Library Project](http://developer.android.com/guide/developing/eclipse-adt.html#libraryProject). This means that there's no need to copy-paste resources into your own project, simply add the action bar component as a reference to any project.

## Usage

### In your layout

    <com.vladexologija.widget.GroupedTextView
        android:id="@+id/grouped_view"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"/>

### In your activity

    GroupedTextView groupedView = (GroupedTextView) findViewById(R.id.grouped_view1);
    groupedView.addPlainTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
    groupedView.addPlainTextView("Cras non tellus vel magna dapibus malesuada.");
    groupedView.addPlainTextView("Phasellus pulvinar, est in sagittis porttitor, ligula metus pretium dui.");
        
    GroupedTextView groupedView = (GroupedTextView) findViewById(R.id.grouped_view2);
    groupedView.addEditTextView("Username","Username");
    groupedView.addEditTextView("Password","Password");
   
## Customization

Since the GroupedTextView is an Libary Project all resources will be merged to the project that referencing the GroupedTextView. The values in the main project will always be used before the default values of the GroupedTextView.
If you don't like the default values that are defined colors, drawables, layouts or somewere else just override them in your project.


