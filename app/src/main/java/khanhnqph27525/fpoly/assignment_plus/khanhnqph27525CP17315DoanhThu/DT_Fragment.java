package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315DoanhThu;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonDATA;
import khanhnqph27525.fpoly.assignment_plus.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DT_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DT_Fragment extends Fragment {
    private ImageView img_dateStart,img_dateEnd;
    private EditText edt_dateStart,edt_dateEnd;
    private TextView tv_doanhThu;
    private Button btn_thongKe;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int mDay,mMonth,mYear;
    public static DT_Fragment newInstance() {
        DT_Fragment fragment = new DT_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_d_t_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_dateStart = view.findViewById(R.id.img_dateStart);
        img_dateEnd = view.findViewById(R.id.img_dateEnd);
        edt_dateStart = view.findViewById(R.id.edt_dateStart);
        edt_dateEnd = view.findViewById(R.id.edt_dateEnd);
        btn_thongKe = view.findViewById(R.id.btn_thongkeDoanhThu);
        tv_doanhThu = view.findViewById(R.id.tv_doanhThu);


        img_dateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d = new DatePickerDialog(getActivity(),0,dateEnd,mYear,mMonth,mDay);
                d.show();
            }
        });

        img_dateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d = new DatePickerDialog(getActivity(),0,dateStart,mYear,mMonth,mDay);
                d.show();
            }
        });
        btn_thongKe.setOnClickListener((v -> {
            String dateS = edt_dateStart.getText().toString();
            String dateE = edt_dateEnd.getText().toString();
            List<Integer> doanhThu = PhieuMuonDATA.getInstance(getContext()).phieuMuonDAO().listDT(dateS,dateE);
            if (doanhThu.get(0)==null){
                tv_doanhThu.setText("0 VND");
            }else {
                tv_doanhThu.setText(doanhThu.get(0)+" VND");
            }
        }));
    }
    DatePickerDialog.OnDateSetListener dateStart = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear = year;
            mMonth = month;
            mDay = dayOfMonth;
            GregorianCalendar c = new GregorianCalendar(mYear,mMonth,mDay);
            edt_dateStart.setText(sdf.format(c.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener dateEnd = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear = year;
            mMonth = month;
            mDay = dayOfMonth;
            GregorianCalendar c = new GregorianCalendar(mYear,mMonth,mDay);
            edt_dateEnd.setText(sdf.format(c.getTime()));
        }
    };

}