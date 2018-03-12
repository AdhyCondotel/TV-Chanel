package com.ammase.androidtvonline.modul;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResponseGetVideo{

	@SerializedName("success")
	private int success;

	@SerializedName("video")
	private List<VideoItem> video;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setVideo(List<VideoItem> video){
		this.video = video;
	}

	public List<VideoItem> getVideo(){
		return video;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGetVideo{" + 
			"success = '" + success + '\'' + 
			",video = '" + video + '\'' + 
			"}";
		}
}