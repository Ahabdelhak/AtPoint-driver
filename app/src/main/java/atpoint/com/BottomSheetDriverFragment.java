package atpoint.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ah_abdelhak on 2/28/2018.
 */
public class BottomSheetDriverFragment extends BottomSheetDialogFragment {
    String mTag;
    public static BottomSheetDriverFragment newInstance(String tag){
        BottomSheetDriverFragment bottomSheetDialogFragment=new BottomSheetDriverFragment();
        Bundle args=new Bundle();
        args.putString("TAG",tag);
        bottomSheetDialogFragment.setArguments(args);
        return bottomSheetDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTag=getArguments().getString("TAG");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottom_sheet_layout,container,false);
        return view;
    }
}