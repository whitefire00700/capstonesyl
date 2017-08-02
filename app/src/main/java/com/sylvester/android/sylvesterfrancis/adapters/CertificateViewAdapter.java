package com.sylvester.android.sylvesterfrancis.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sylvester.android.sylvesterfrancis.R;
import com.sylvester.android.sylvesterfrancis.data.Certificate;

import java.util.List;

/**
 * Created by sylvester on 30/07/17.
 */

public class CertificateViewAdapter extends RecyclerView.Adapter<CertificateViewAdapter.CertificateViewHolder> {

    private List<Certificate> certificateList;

    static final int TYPE_HEADER = 0;

    public class CertificateViewHolder extends RecyclerView.ViewHolder {
        public TextView title, authority;
        public ImageView Image_id;

        public CertificateViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.certificate_title);
            authority = view.findViewById(R.id.certificate_authority);
            Image_id =  view.findViewById(R.id.image_certificate);
        }
    }



    public CertificateViewAdapter(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_HEADER;
        }
    }

    @Override
    public CertificateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.certificates_layout, parent, false);
                return new CertificateViewHolder(view) {
                };
            }
        }
        return null;

    }

    @Override
    public void onBindViewHolder(CertificateViewHolder holder, int position) {
       Certificate certificate = certificateList.get(position);
        holder.title.setText(certificate.gettitle());
        holder.authority.setText(certificate.getauthority());
        holder.Image_id.setImageResource(certificate.getCertificate_id());
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return certificateList.size();
    }
}