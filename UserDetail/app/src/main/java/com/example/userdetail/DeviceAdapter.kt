package com.example.userdetail

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DeviceAdapter(val deviceList: List<Device> ): RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceAdapter.DeviceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_detail_list_layout,parent,false)
        return DeviceViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("tag", "userList"+deviceList.size)
        return deviceList.size
    }

    override fun onBindViewHolder(holder: DeviceAdapter.DeviceViewHolder, position: Int) {
        holder.deviceBind(deviceList[position])
    }


    class DeviceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun deviceBind(device: Device)
        {
            val textViewDeviceName = itemView.findViewById<TextView>(R.id.deviceNameTextViewId)
            val textViewDeviceModel = itemView.findViewById<TextView>(R.id.deviceModelTextViewId)
            val textViewDeviceDate = itemView.findViewById<TextView>(R.id.deviceDateTextViewId)

            textViewDeviceName.text = "Device name : "+device.deviceName
            textViewDeviceModel.text = "Device model : "+device.deviceModel
            textViewDeviceDate.text = "Date : "+device.deviceDate
        }


    }

}