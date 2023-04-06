package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

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

public class T_EX_Adapter extends RecyclerView.Adapter<T_EX_Adapter.ObjTeXViewHolder> {
    private Context context;
    private List<DTO_T_EX> arrayList;
    private DTO_T_EX dtoTEx_new;
    public T_EX_Adapter(Context context) {
        this.context = context;
    }
    public void setDataTeX(List<DTO_T_EX> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjTeXViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_t_ex, parent, false);
        return new ObjTeXViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjTeXViewHolder holder, int position) {
        DTO_T_EX dtoTEx = arrayList.get(position);
        if (dtoTEx == null) {
            return;
        }
        holder.loaiSP.setText("Loại sản phầm: "+dtoTEx.getLoaiSp());
        holder.maSP.setText("Mã sản phẩm: "+dtoTEx.getMaSp());
        holder.tenSP.setText("Tên sản phẩm: "+dtoTEx.getTenSp());
        holder.soLuong.setText("Số lượng: "+dtoTEx.getSoLuong()+"");
        holder.donGia.setText("Đơn giá: "+dtoTEx.getDonGia()+"");
        holder.hanSD.setText("Hạn sử dụng: "+dtoTEx.getHanSd());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa");
                builder.setMessage("Bạn có chắc muốn xóa không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        T_EX_DATA.getInstance(v.getContext()).tExDao().getObjidSP(dtoTEx.getIdsanPham());
                        arrayList = T_EX_DATA.getInstance(v.getContext()).tExDao().getListObjSP();
                        setDataTeX(arrayList);
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
                builder.setMessage("Bạn muốn sửa không?");
                builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog2 = new Dialog(v.getContext(), androidx.appcompat.R.style.Base_Theme_AppCompat_Light_Dialog_Alert);
                        dialog2.setContentView(R.layout.dialog_update_t_ex);

                        EditText edt_loaiSPup = dialog2.findViewById(R.id.edt_loaisP_up);
                        EditText edt_maSPup = dialog2.findViewById(R.id.edt_masP_up);
                        EditText edt_tenSPup = dialog2.findViewById(R.id.edt_tensP_up);
                        EditText edt_soLuongup = dialog2.findViewById(R.id.edt_soLuong_tEx_up);
                        EditText edt_donGiaup = dialog2.findViewById(R.id.edt_donGia_tEx_up);
                        EditText edt_hanSDup = dialog2.findViewById(R.id.edt_hanSD_up);
                        Button btn_cancel = dialog2.findViewById(R.id.btn_cancelSP_up);
                        Button btn_update = dialog2.findViewById(R.id.btn_updateSP);
                        edt_loaiSPup.setText(dtoTEx.getLoaiSp());
                        edt_maSPup.setText(dtoTEx.getMaSp());
                        edt_tenSPup.setText(dtoTEx.getTenSp());
                        edt_soLuongup.setText(dtoTEx.getSoLuong()+"");
                        edt_donGiaup.setText(dtoTEx.getDonGia()+"");
                        edt_hanSDup.setText(dtoTEx.getHanSd());

                        btn_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                            }
                        });
                        btn_update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(edt_loaiSPup.getText().toString().trim().isEmpty()||edt_maSPup.getText().toString().trim().isEmpty()||edt_tenSPup.getText().toString().trim().isEmpty()||edt_soLuongup.getText().toString().trim().isEmpty()||edt_donGiaup.getText().toString().trim().isEmpty()||edt_hanSDup.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống mã sách", Toast.LENGTH_SHORT).show();
                                }else{
                                    dtoTEx_new = dtoTEx;
                                    dtoTEx_new.setLoaiSp(edt_loaiSPup.getText().toString());
                                    dtoTEx_new.setMaSp(edt_maSPup.getText().toString());
                                    dtoTEx_new.setTenSp(edt_tenSPup.getText().toString());
                                    dtoTEx_new.setSoLuong(Integer.parseInt(edt_soLuongup.getText().toString()));
                                    dtoTEx_new.setDonGia(Integer.parseInt(edt_donGiaup.getText().toString()));
                                    dtoTEx_new.setHanSd(edt_hanSDup.getText().toString());
                                    T_EX_DATA.getInstance(v.getContext()).tExDao().updateObjSP(dtoTEx_new);
                                    arrayList = T_EX_DATA.getInstance(v.getContext()).tExDao().getListObjSP();
                                    setDataTeX(arrayList);
                                    Toast.makeText(v.getContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                                }
                                dialog2.dismiss();
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


    public class ObjTeXViewHolder extends RecyclerView.ViewHolder{
        private TextView loaiSP;
        private TextView maSP;
        private TextView tenSP;
        private TextView soLuong;
        private TextView donGia;
        private TextView hanSD;
        private ImageView img_delete;
        public ObjTeXViewHolder(@NonNull View itemView) {
            super(itemView);
            loaiSP = itemView.findViewById(R.id.tv_loaiSP);
            maSP = itemView.findViewById(R.id.tv_maSP);
            tenSP = itemView.findViewById(R.id.tv_tenSP);
            soLuong = itemView.findViewById(R.id.tv_soLuongSP);
            donGia = itemView.findViewById(R.id.tv_donGiaSP);
            hanSD = itemView.findViewById(R.id.tv_hanSDSP);
            img_delete = itemView.findViewById(R.id.img_delete_TeX);
        }
    }
}
