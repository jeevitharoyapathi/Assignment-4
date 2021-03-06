
package android.databinding;
import com.codepath.apps.jeevitharoyapathi.BR;
class DataBinderMapper {
    final static int TARGET_MIN_SDK = 16;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.codepath.apps.jeevitharoyapathi.R.layout.activity_compose:
                    return com.codepath.apps.jeevitharoyapathi.databinding.ActivityComposeBinding.bind(view, bindingComponent);
                case com.codepath.apps.jeevitharoyapathi.R.layout.toolbar:
                    return com.codepath.apps.jeevitharoyapathi.databinding.ToolbarBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -27571560: {
                if(tag.equals("layout/activity_compose_0")) {
                    return com.codepath.apps.jeevitharoyapathi.R.layout.activity_compose;
                }
                break;
            }
            case 519370695: {
                if(tag.equals("layout/toolbar_0")) {
                    return com.codepath.apps.jeevitharoyapathi.R.layout.toolbar;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"tweet"};
    }
}