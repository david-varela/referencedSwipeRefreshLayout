# Sample of ReferencedSwipeRefreshLayout

For use this view, you have to follow the next steps:

* Replace in your layout de official SwipeRefreshLayout by the one in the library, es.dagova.referencedswiperefreshlayout.library.ReferencedSwipeRefreshLayout.
* Fill the attribute referencedswiperefreshlayout:adapter_view= with a new id (@+id/your_view) that references your adapterView (ListView, ScrollView...).
* Create a unique view as child of the ReferencedSwipeRefreshLayout, as the original SwipeRefreshLayout demands. You can use a LinearLayout or a RelativeLayout, for example.
* Include, inside the child, all the views you want. One of them should be your adapterView, and the id has to be the referenced previously (android:id="@id/your_view").
* In case of use another view as empty state of your adapterView, the emptyStateView should be clickable (android:clickable="true"). 