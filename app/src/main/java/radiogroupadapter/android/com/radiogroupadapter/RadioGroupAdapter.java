package radiogroupadapter.android.com.radiogroupadapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akshay trivedi on 25/03/18.
 */

public class RadioGroupAdapter extends RecyclerView.Adapter<RadioGroupAdapter.ViewHolder> {

    private List<RadioGroupMode> mModeList;
    private Context mContext;
    private int previousPos = -1;
    private OnItemSelectedListener onItemSelectedListener;
    private int byDefaultPos = 0;

    public RadioGroupAdapter(Context context, List<RadioGroupMode> list, OnItemSelectedListener onItemSelectedListener, int position) {
        this.mContext = context;
        this.mModeList = list;
        this.onItemSelectedListener = onItemSelectedListener;
        this.byDefaultPos = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_group_mode_item, parent, false);
        return new RadioGroupAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (byDefaultPos == position) {
            byDefaultPos = -1;
            previousPos = position;
            holder.ivMode.setImageDrawable(ContextCompat.getDrawable(mContext, mModeList.get(position).getModeImageSelected()));
            onItemSelectedListener.onItemSelected(position);
        } else {
            holder.ivMode.setImageDrawable(ContextCompat.getDrawable(mContext, mModeList.get(position).getModeImage()));
        }
        holder.tvModeName.setText(mModeList.get(position).getModeName());
        holder.ivMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMode(position, holder.itemView);
            }
        });
    }

    public void setMode(int position, View view) {
        if (previousPos != position) {
            ImageView modeImage = (ImageView) view.findViewById(R.id.ivMode);
            if (previousPos != -1) {
                byDefaultPos = position;
                notifyItemChanged(position);
                notifyItemChanged(previousPos);
            }
            previousPos = position;
            if (modeImage.getDrawable().getConstantState() == ContextCompat.getDrawable(mContext, mModeList.get(position).getModeImage()).getConstantState()) {
                modeImage.setImageDrawable(ContextCompat.getDrawable(mContext, mModeList.get(position).getModeImageSelected()));
            } else {
                modeImage.setImageDrawable(ContextCompat.getDrawable(mContext, mModeList.get(position).getModeImage()));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mModeList.size();
    }

    public interface OnItemSelectedListener {
        public void onItemSelected(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivMode;
        private TextView tvModeName;

        public ViewHolder(View itemView) {
            super(itemView);
            ivMode = (ImageView) itemView.findViewById(R.id.ivMode);
            tvModeName = (TextView) itemView.findViewById(R.id.tvModeName);
        }
    }
}
