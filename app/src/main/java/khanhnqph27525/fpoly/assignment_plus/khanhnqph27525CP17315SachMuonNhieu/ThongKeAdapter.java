package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315SachMuonNhieu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;

public class ThongKeAdapter extends RecyclerView.Adapter<ThongKeAdapter.ObjThongKeViewHolder>{
    private Context context;
    private List<ThongKe> arrayList;

    public ThongKeAdapter(Context context) {
        this.context = context;
    }
    public void setDataTK(List<ThongKe> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjThongKeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongke, parent, false);
        return new ObjThongKeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjThongKeViewHolder holder, int position) {
        ThongKe thongKe = arrayList.get(position);
        if (thongKe == null) {
            return;
        }
        holder.tenSach.setText(arrayList.get(position).getKhanhnqph27525CP17315tenSach());
        holder.soLuong.setText(arrayList.get(position).getKhanhnqph27525CP17315soLuong()+"");
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class ObjThongKeViewHolder extends RecyclerView.ViewHolder{
        private TextView tenSach;
        private TextView soLuong;
        public ObjThongKeViewHolder(@NonNull View itemView) {
            super(itemView);
            tenSach = itemView.findViewById(R.id.tv_tenSach_TK);
            soLuong = itemView.findViewById(R.id.tv_soLuong);
        }
    }
}
