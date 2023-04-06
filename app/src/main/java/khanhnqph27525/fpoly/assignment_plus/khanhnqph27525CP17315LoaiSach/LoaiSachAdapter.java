package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;

public class LoaiSachAdapter extends RecyclerView.Adapter<LoaiSachAdapter.ObjLoaiSachViewHolder>{
    private Context context;
    private List<LoaiSachEntity> arrayList;
    private LoaiSachEntity loaiSachNew;

    public LoaiSachAdapter(Context context) {
        this.context = context;
    }
    public void setDataLS(List<LoaiSachEntity> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjLoaiSachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loaisach, parent, false);
        return new ObjLoaiSachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjLoaiSachViewHolder holder, int position) {
        LoaiSachEntity loaiSach = arrayList.get(position);
        if (loaiSach == null) {
            return;
        }
        holder.maLoaiSach.setText(arrayList.get(position).getKhanhnqph27525CP17315maLoai()+"");
        holder.tenLoaiSach.setText(arrayList.get(position).getKhanhnqph27525CP17315tenLoai());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa");
                builder.setMessage("Bạn có chắc muốn xóa không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoaiSachDATA.getInstance(v.getContext()).loaiSachDAO().getObjidLS(loaiSach.getKhanhnqph27525CP17315idloaisach());
                        arrayList = LoaiSachDATA.getInstance(v.getContext()).loaiSachDAO().getListObjLS();
                        setDataLS(arrayList);
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(context, "Hủy xóa", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Lựa chọn:");
                builder.setMessage("Bạn muốn sửa hay xem chi tiết?");
                builder.setPositiveButton("chi tiết", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog1 = new Dialog(v.getContext(), androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert);
                        dialog1.setContentView(R.layout.detail_loaisach);
                        TextView tv_ma = dialog1.findViewById(R.id.tv_maLS);
                        TextView tv_ten = dialog1.findViewById(R.id.tv_tenLS);
                        tv_ma.setText(loaiSach.getKhanhnqph27525CP17315maLoai()+"");
                        tv_ten.setText(loaiSach.getKhanhnqph27525CP17315tenLoai());

                        dialog1.show();
                    }
                });
                builder.setNegativeButton("sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog2 = new Dialog(v.getContext(), androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert);
                        dialog2.setContentView(R.layout.dialog_update_loaisach);
                        EditText edt_ma = dialog2.findViewById(R.id.edt_maloaisach_up);
                        EditText edt_ten = dialog2.findViewById(R.id.edt_tenloaisach_up);
                        Button btn_cancel = dialog2.findViewById(R.id.btn_cancel_loaiSach_up);
                        Button btn_add = dialog2.findViewById(R.id.btn_update_loaiSach);
                        edt_ma.setText(loaiSach.getKhanhnqph27525CP17315maLoai()+"");
                        edt_ten.setText(loaiSach.getKhanhnqph27525CP17315tenLoai());
                        btn_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                            }
                        });
                        btn_add.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (edt_ma.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống mã loại sách", Toast.LENGTH_SHORT).show();
                                }else if (edt_ten.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống tên loại sách", Toast.LENGTH_SHORT).show();
                                }else {
                                    loaiSachNew = loaiSach;
                                    loaiSachNew.setKhanhnqph27525CP17315maLoai(Integer.parseInt(edt_ma.getText().toString().trim()));
                                    loaiSachNew.setKhanhnqph27525CP17315tenLoai(edt_ten.getText().toString().trim());
                                    LoaiSachDATA.getInstance(v.getContext()).loaiSachDAO().updateObjLS(loaiSachNew);
                                    arrayList = LoaiSachDATA.getInstance(v.getContext()).loaiSachDAO().getListObjLS();
                                    setDataLS(arrayList);
                                    dialog2.dismiss();
                                }
                            }
                        });
                        dialog2.show();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class ObjLoaiSachViewHolder extends RecyclerView.ViewHolder{
        private TextView maLoaiSach;
        private TextView tenLoaiSach;
        private ImageView img_delete;
        public ObjLoaiSachViewHolder(@NonNull View itemView) {
            super(itemView);
            maLoaiSach = itemView.findViewById(R.id.tv_maLoai);
            tenLoaiSach = itemView.findViewById(R.id.tv_tenLoaiSach);
            img_delete = itemView.findViewById(R.id.img_delete_LS);
        }
    }
}
