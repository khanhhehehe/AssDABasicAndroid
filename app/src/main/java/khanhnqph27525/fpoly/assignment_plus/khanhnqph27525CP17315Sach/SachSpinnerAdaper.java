package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachEntity;
import khanhnqph27525.fpoly.assignment_plus.R;

public class SachSpinnerAdaper extends BaseAdapter {
    private Context context;
    private List<LoaiSachEntity> arrayList;
    private int layout;

    public SachSpinnerAdaper(Context context, List<LoaiSachEntity> arrayList, int layout) {
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
        SachHolder viewHolder = null;
        if (convertView==null){
            viewHolder = new SachHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layout,null);
            viewHolder.name = convertView.findViewById(R.id.sp_item_loaisach);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (SachHolder) convertView.getTag();
        }
        viewHolder.name.setText(arrayList.get(position).getKhanhnqph27525CP17315tenLoai());
        return convertView;
    }
    public static class SachHolder{
        private TextView name;
    }
}
