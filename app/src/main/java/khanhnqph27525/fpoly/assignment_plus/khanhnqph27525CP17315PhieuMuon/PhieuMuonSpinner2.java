package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachEntity;

public class PhieuMuonSpinner2 extends BaseAdapter {
    private Context context;
    private List<SachEntity> arrayList;
    private int layout;

    public PhieuMuonSpinner2(Context context, List<SachEntity> arrayList, int layout) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SachPMHolder viewHolder = null;
        if (convertView==null){
            viewHolder = new SachPMHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layout,null);
            viewHolder.name = convertView.findViewById(R.id.sp_item_loaisach);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (SachPMHolder) convertView.getTag();
        }
        viewHolder.name.setText(arrayList.get(position).getKhanhnqph27525CP17315tenSach());
        return convertView;
    }
    public static class SachPMHolder{
        private TextView name;
    }
}
