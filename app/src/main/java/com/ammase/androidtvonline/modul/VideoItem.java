package com.ammase.androidtvonline.modul;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class VideoItem{

	@SerializedName("kode_video")
	private String kodeVideo;

	@SerializedName("artikel")
	private String artikel;

	@SerializedName("nama_video")
	private String namaVideo;

	@SerializedName("lokasi")
	private String lokasi;

	@SerializedName("tgl_posting")
	private String tglPosting;

	@SerializedName("video")
	private String video;

	public void setKodeVideo(String kodeVideo){
		this.kodeVideo = kodeVideo;
	}

	public String getKodeVideo(){
		return kodeVideo;
	}

	public void setArtikel(String artikel){
		this.artikel = artikel;
	}

	public String getArtikel(){
		return artikel;
	}

	public void setNamaVideo(String namaVideo){
		this.namaVideo = namaVideo;
	}

	public String getNamaVideo(){
		return namaVideo;
	}

	public void setLokasi(String lokasi){
		this.lokasi = lokasi;
	}

	public String getLokasi(){
		return lokasi;
	}

	public void setTglPosting(String tglPosting){
		this.tglPosting = tglPosting;
	}

	public String getTglPosting(){
		return tglPosting;
	}

	public void setVideo(String video){
		this.video = video;
	}

	public String getVideo(){
		return video;
	}

	@Override
 	public String toString(){
		return 
			"VideoItem{" + 
			"kode_video = '" + kodeVideo + '\'' + 
			",artikel = '" + artikel + '\'' + 
			",nama_video = '" + namaVideo + '\'' + 
			",lokasi = '" + lokasi + '\'' + 
			",tgl_posting = '" + tglPosting + '\'' + 
			",video = '" + video + '\'' + 
			"}";
		}
}