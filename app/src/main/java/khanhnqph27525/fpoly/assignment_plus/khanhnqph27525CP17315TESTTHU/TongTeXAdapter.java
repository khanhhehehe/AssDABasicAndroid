package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;


public class TongTeXAdapter extends RecyclerView.Adapter<TongTeXAdapter.ObjTongViewHolder> {
    private Context context;
    private List<TongTexDTO> arrayList;

    public TongTeXAdapter(Context context) {
        this.context = context;
    }
    public void setDataTong(List<TongTexDTO> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ObjTongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tong_t_ex, parent, false);
        return new ObjTongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjTongViewHolder holder, int position) {
        TongTexDTO tongTeX = arrayList.get(position);
        if (tongTeX == null) {
            return;
        }
        holder.tenSP.setText(arrayList.get(position).getLoaiSp());
        holder.giaSP.setText(arrayList.get(position).getGiaTongSP()+"");
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class ObjTongViewHolder extends RecyclerView.ViewHolder{
        private TextView tenSP;
        private TextView giaSP;
        public ObjTongViewHolder(@NonNull View itemView) {
            super(itemView);
            tenSP = itemView.findViewById(R.id.tv_tenSP_tong);
            giaSP = itemView.findViewById(R.id.tv_giaSP_tong);
        }
    }
}
