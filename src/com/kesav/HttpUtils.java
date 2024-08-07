package com.kesav;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

	public static void TheKing_DownloadFileFromURL(String fromFile, String toFile, String fileName) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			URL url = new URL(fromFile);
			String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
			URLConnection con = url.openConnection();
			con.setRequestProperty("User-Agent", USER_AGENT);
			int contentLength = con.getContentLength();
//			System.out.println("File contentLength = " + contentLength + " bytes");
			System.out.println("File Name: " + fileName + ", Size: " + contentLength + " bytes");
			inputStream = con.getInputStream();
			outputStream = new FileOutputStream(toFile);
			byte[] buffer = new byte[2048];
			int length;
			int downloaded = 0;
			while ((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
				downloaded += length;
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}

		if (outputStream != null)
			outputStream.close();

		if (inputStream != null)
			inputStream.close();
	}
	public static void main(String args[]) {
		
		Map<String, String> downloadFiles = new HashMap<String, String>();

/*		
		downloadFiles.put("https://szcdn.ragalahari.com/feb2014/photosessions/sarada-rani-ragalahari-photo-shoot/","sarada-rani-ragalahari-photo-shoot");
		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/photosessions/sarada-rani-hot-photoshoot/", "sarada-rani-hot-photoshoot"	);
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/photosessions/sarada-rani-ragalahari-photos/", "sarada-rani-ragalahari-photos");
		downloadFiles.put("https://starzone.ragalahari.com/oct2014/photosessions/akshaya-rao-half-saree/", "akshaya-rao-half-saree");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2014/photosessions/heroine-akshaya-rao/", "heroine-akshaya-rao");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2019/posters/nandini-ks-100-audio-launch/", "nandini-ks-100-audio-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/photosessions/geeta-half-saree-shoot/", "geeta-half-saree-shoot");
		downloadFiles.put("https://szcdn.ragalahari.com/april2014/photosessions/hyderabad-hot-model-madhuri/", "hyderabad-hot-model-madhuri");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/photosessions/hyderabad-model-madhuri-saree-shoot/", "hyderabad-model-madhuri-saree-shoot");
		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/photosessions/telugu-girl-madhuri/", "telugu-girl-madhuri");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/photosessions/model-madhuri-pink-dress-ragalahari/", "model-madhuri-pink-dress-ragalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/photosessions/madhuri-photoshoot/", "madhuri-photoshoot");
/*		downloadFiles.put("https://starzone.ragalahari.com/april2018/starzone/priya-augustin-yellow-dress/","priya-augustin-yellow-dress10");		
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/priyanka-augustin-hd-wallpapers/","priyanka-augustin-hd-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/mar2017/photosessions/priyanka-augustin-pink-blue-dress/","priyanka-augustin-pink-blue-dress");
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/posters/priya-at-pochampally-ikat-artmela/","priya-at-pochampally-ikat-artmela");
		downloadFiles.put("https://starzone.ragalahari.com/june2017/photosessions/priyanka-augustin-in-half-saree/","priyanka-augustin-in-half-saree");
		downloadFiles.put("https://starzone.ragalahari.com/june2021/photosessions/priyanka-augustin-yellow-divided-skirt-rps/","priyanka-augustin-yellow-divided-skirt-rps");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/starzone/priya-augustin-yellow-dress/","priya-augustin-yellow-dress10");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/proia-augustin-long-frock-hd-photos/","proia-augustin-long-frock-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-red-shirt-denim-shorts-rps/","priyanka-augustin-red-shirt-denim-shorts-rps");
		downloadFiles.put("https://starzone.ragalahari.com/july2019/posters/priya-augustin-mass-power-50days/","priya-augustin-mass-power-50days");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/proia-augustin-long-frock-hd-photos/","proia-augustin-long-frock-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/photosessions/priyanka-augustin-traditional-diya-rps/","priyanka-augustin-traditional-diya-rps");
		downloadFiles.put("https://starzone.ragalahari.com/dec2020/hd/priya-augustin-super-power-trailer/", "priya-augustin-super-power-trailer");
		downloadFiles.put("https://starzone.ragalahari.com/april2019/hd/priya-augustin-runam-pm/", "priya-augustin-runam-pm");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/feb2015/photosessions/manisha-pillai-ragalahari/", "manisha-pillai-ragalahari");
//		downloadFiles.put("https://starzone.ragalahari.com/august2009/starzone/waheeda5/", "waheeda");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/feb2017/photosessions/priyanka-augustin-hd-pics-in-blue-dress/", "priyanka-augustin-hd-pics-in-blue-dress");
		downloadFiles.put("https://starzone.ragalahari.com/dec2017/starzone/priyanka-augustin-red-dress/", "priyanka-augustin-red-dress");
		downloadFiles.put("https://starzone.ragalahari.com/june2018/hd/priya-augustin-wallpapers/", "priya-augustin-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/june2018/starzone/priyanka-augustin-saree/", "priyanka-augustin-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2018/starzone/augustin-priya/","augustin-priya");
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/model-priyanka-augustin-hd-photos/","model-priyanka-augustin-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/mar2018/posters/priya-augustin-jawedhabib-salon-launch/","priya-augustin-jawedhabib-salon-launch");
		downloadFiles.put("https://starzone.ragalahari.com/feb2018/posters/priya-augustin-blue-saree/","priya-augustin-blue-saree");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-white-stripes-top-shorts-rps/","priyanka-augustin-white-stripes-top-shorts-rps");		
		downloadFiles.put("https://starzone.ragalahari.com/aug2014/starzone/manisha-kanyarajsons/","manisha-kanyarajsons");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/photosessions/manisha-pillai-ragalahari-photos/","manisha-pillai-ragalahari-photos");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/model-manisha-pillai/","model-manisha-pillai");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/photosessions/manisha-pillai-ragalahari-glam-stills/","manisha-pillai-ragalahari-glam-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/may2015/posters/manisha-pilla-item-song/","manisha-pilla-item-song");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/manisha-pillai/","manisha-pillai");
		downloadFiles.put("https://starzone.ragalahari.com/july2015/hd/manisha-pillai-high-definition/","manisha-pillai-high-definition");		
		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/manisha-pillai-pics/","manisha-pillai-pics");				
		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/manisha-pillai-wallpapers/","manisha-pillai-wallpapers");		
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/starzone/manisha-pillai-club-republic/","manisha-pillai-club-republic");		
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/starzone/manisha-pillai-club-republic-photos/","manisha-pillai-club-republic-photos");		
		downloadFiles.put("https://starzone.ragalahari.com/nov2015/starzone/manisha-pillai/","manisha-pillai");				
		downloadFiles.put("https://starzone.ragalahari.com/dec2015/posters/manisha-pillai-saree-stills/","manisha-pillai-saree-stills");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/starzone/manisha-pillai-traditional-queen/","manisha-pillai-traditional-queen");		
		downloadFiles.put("https://starzone.ragalahari.com/feb2016/starzone/manisha-pillai-kismet-pub/","manisha-pillai-kismet-pub");
		downloadFiles.put("https://starzone.ragalahari.com/feb2016/photosessions/manisha-pillai-pics/","manisha-pillai-pics");		
		downloadFiles.put("https://starzone.ragalahari.com/may2017/posters/manisha-pillai-akriti-exhibition/","manisha-pillai-akriti-exhibition");
		downloadFiles.put("https://starzone.ragalahari.com/july2017/starzone/manisha-pillai/","manisha-pillai");		
		downloadFiles.put("https://starzone.ragalahari.com/aug2020/hd/manisha-pillai-aug2020/","manisha-pillai-aug2020");
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/hd/manisha-pillai-nov1320/","manisha-pillai-nov1320");		
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/hd/manisha-pillai-pink-lehenga/","manisha-pillai-pink-lehenga");		
		downloadFiles.put("https://starzone.ragalahari.com/dec2020/hd/manisha-pillai/","manisha-pillai");		
		downloadFiles.put("https://starzone.ragalahari.com/feb2021/hd/sadhana-pillai-white-dress/","sadhana-pillai-white-dress");		
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/photosessions/manisha-pillai-actress-ragalahari/","manisha-pillai-actress-ragalahari");		
		downloadFiles.put("https://starzone.ragalahari.com/oct2012/hd/kavya-singh-hot-masala/","kavya-singh-hot-masala");		
		downloadFiles.put("https://starzone.ragalahari.com/oct2011/starzone/shravya-reddy-highres-portfolio/","shravya-reddy-highres-portfolio");		
		downloadFiles.put("https://szcdn.ragalahari.com/june2012/starzone/shravya-reddy-highres/","shravya-reddy-highres");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/starzone/shravya-reddy-nri-audio/","shravya-reddy-nri-audio");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/photosessions/shravya-reddy-short-prom-dress/","shravya-reddy-short-prom-dress");		
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/starzone/shravya-reddy-heroine-nri/","shravya-reddy-heroine-nri");		
		downloadFiles.put("https://szcdn1.ragalahari.com/dec2012/photosessions/shravya-reddy-studio-shoot/","shravya-reddy-studio-shoot");		
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/posters/shravya-reddy-red-dress/","shravya-reddy-red-dress");		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/starzone/shravya-reddy-aey-audio-release/","shravya-reddy-aey-audio-release");		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/starzone/shravya-reddy-hotel-golden-park/","shravya-reddy-hotel-golden-park");		
		downloadFiles.put("https://szcdn.ragalahari.com/feb2013/starzone/shravya-reddy-neerus-designer-embroidery/","shravya-reddy-neerus-designer-embroidery");		
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/hd/nri-movie-heroine-shravya-reddy/","nri-movie-heroine-shravya-reddy");		
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/shravya-reddy-nri-platinum-disc/","shravya-reddy-nri-platinum-disc");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/photosessions/shravya-reddy-black-dress/","shravya-reddy-black-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shravya-reddy-mozarella/","shravya-reddy-mozarella");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shraavya-reddy-portfolio-pics/","shraavya-reddy-portfolio-pics");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/starzone/shravya-reddy-sleepwell/","shravya-reddy-sleepwell");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shravya-sasya-summer-wedding-line-launch/", "shravya-sasya-summer-wedding-line-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/june2013/starzone/shravya-reddy-at-sundown2-aqua/", "shravya-reddy-at-sundown2-aqua");
		downloadFiles.put("https://img.ragalahari.com/june2013/starzone/shravyareddy-hyderabad-fashion-week/", "shravyareddy-hyderabad-fashion-week");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/shravya-reddy-rainbow-shopping/", "shravya-reddy-rainbow-shopping");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2013/posters/heroine-sravya-reddy/", "heroine-sravya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/shravya-reddy-melange-exhibition-2013/", "shravya-reddy-melange-exhibition-2013");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/starzone/eyy-heroine-shravya-reddy/", "eyy-heroine-shravya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/hd/shravyareddy-hiya-varalakshmi-vratam/", "shravyareddy-hiya-varalakshmi-vratam");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2013/starzone/shravya-reddy-radisson-blu/", "shravya-reddy-radisson-blu");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2013/starzone/shravya-reddy-vasanthayanam-pressmeet/", "shravya-reddy-vasanthayanam-pressmeet");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/starzone/shravya-reddy-at-fashion-show-at-spoil/", "shravya-reddy-at-fashion-show-at-spoil");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2014/starzone/hyderabad-heroine-sravya-reddy/", "hyderabad-heroine-sravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/sravya-reddy-hot/", "sravya-reddy-hot");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/starzone/shravyareddy-tasyaah-awareness-fashion-walk/", "shravyareddy-tasyaah-awareness-fashion-walk");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/starzone/sravya-reddy-portfolio/", "sravya-reddy-portfolio");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-veerudokkade-audio/", "shravya-reddy-veerudokkade-audio");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2014/starzone/shravya-reddy-op-everest-in-pictures/", "shravya-reddy-op-everest-in-pictures");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/starzone/shravya-reddy-at-premaloabc-audio/", "shravya-reddy-at-premaloabc-audio");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-kismet-march21-2014/", "shravya-reddy-kismet-march21-2014");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-vijaya-rana-franchise-launch/", "shravya-reddy-vijaya-rana-franchise-launch");
		downloadFiles.put("https://imgcdn.ragalahari.com/aug2014/starzone/heroine-shravya-reddy/", "heroine-shravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/posters/shraavya-reddy/", "shraavya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/starzone/shraavya-reddy-in-white-dress/", "shraavya-reddy-in-white-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/posters/shraavya-reddy-heroine/shraavya-reddy-heroine1t.jpg", "heroine-shravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/starzone/shravyareddy/", "shravyareddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/shravya-reddy-hyderabad-actress/", "shravya-reddy-hyderabad-actress");
		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/sravya-reddy-hot-stills/", "sravya-reddy-hot-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/photosessions/sravya-reddy-raagalahari/", "sravya-reddy-raagalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/hd/heroine-shravya-hot-pics/", "heroine-shravya-hot-pics");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/shravyareddy-stateart-gallery/", "shravyareddy-stateart-gallery");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/hd/shravya-reddy-high-definition-photos/", "shravya-reddy-high-definition-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2017/posters/shravya-reddy-balakrishnudu-pre-release/", "shravya-reddy-balakrishnudu-pre-release");
		downloadFiles.put("https://szcdn.ragalahari.com/june2017/posters/shravya-reddy-hq-stills-in-red-dress/", "shravya-reddy-hq-stills-in-red-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2017/hd/shravya-reddy-rogue-teaser-launch/", "shravya-reddy-rogue-teaser-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/posters/shravya-reddy-diwali-hq-photos/", "shravya-reddy-diwali-hq-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shraavya-reddy-green-pleated-jumpsuit-rps/", "shraavya-reddy-green-pleated-jumpsuit-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shravya-reddy-mint-green-saree-rps/", "shravya-reddy-mint-green-saree-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shravya-reddy-purple-dress-rps/", "shravya-reddy-purple-dress-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2018/hd/shraavya-reddy-vastaa-genesis-cr/", "shraavya-reddy-vastaa-genesis-cr");
		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/teertha4/", "teertha4");
		downloadFiles.put("https://szcdn.ragalahari.com/august2009/starzone/teertha8/", "teertha8");
		downloadFiles.put("https://starzone.ragalahari.com/dec2017/hd/geet-shah-yellow-saree/", "geet-shah-yellow-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2017/photosessions/monica-thompson-red-long-skirt/", "monica-thompson-red-long-skirt");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/monica-thompson-actress-hot-stills-ragalahari/", "monica-thompson-actress-hot-stills-ragalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/photosessions/tamil-actress-monica-thompson-photos/", "tamil-actress-monica-thompson-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/photosessions/monica-thompson-in-designer-dress/", "monica-thompson-in-designer-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/april2014/photosessions/mithuna-waliya-ragalahari-photos/", "mithuna-waliya-ragalahari-photos");
		downloadFiles.put("https://szcdn1.ragalahari.com/oct2013/photosessions/mithuna-waliya-hot-unseen-photos/", "mithuna-waliya-hot-unseen-photos");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2013/starzone/mithuna-waliya-lovejunction-platinum/", "mithuna-waliya-lovejunction-platinum");
		downloadFiles.put("https://szcdn.ragalahari.com/april2016/starzone/midhuna-in-saree-stills/", "midhuna-in-saree-stills");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/photosessions/vennilavin-arangetram-mithuna-waliya/", "vennilavin-arangetram-mithuna-waliya");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2015/hd/monica-thompson-hot-pics/", "monica-thompson-hot-pics");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/pooja-sree-glam-photos/", "pooja-sree-glam-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/may2022/hd/eesha-rebba-shekar-trailer-launch/", "eesha-rebba-shekar-trailer-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/april2017/photosessions/sindhura-rout-in-mini-frock-hd-stills/", "sindhura-rout-in-mini-frock-hd-stills");
		downloadFiles.put("https://img.ragalahari.com/gallery/sundhutolani3/", "sundhutolani3");
		downloadFiles.put("https://img.ragalahari.com/gallery/sindhutolani4/", "sindhutolani4");
		downloadFiles.put("https://img.ragalahari.com/gallery/sindhutolani4/", "sindhutolani4");
		downloadFiles.put("https://starzone.ragalahari.com/june2008gallery/sindhutolani7/", "sindhutolani7");
		downloadFiles.put("https://starzone.ragalahari.com/march2008gallery/sindhutolani6/", "sindhutolani6");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-minibalcktop-ragalahari-ps/", "deepika3-minibalcktop-ragalahari-ps");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-silver-dress-set2-ragalahari-ps/", "deepika3-silver-dress-set2-ragalahari-ps");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2012/starzone/deepika3-white-top-ragalahari-ps/", "deepika3-white-top-ragalahari-ps");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-black-white-ragalahari-ps/", "deepika3-black-white-ragalahari-ps");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-pink-saree-ragalahari-ps/", "deepika3-pink-saree-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/starzone/vinisha-naidu-movie-shoot/", "vinisha-naidu-movie-shoot");
		downloadFiles.put("https://szcdn1.ragalahari.com/april2012/starzone/hema-ragalahari-photo-session/", "hema-ragalahari-photo-session");
		downloadFiles.put("https://szcdn.ragalahari.com/september2009/starzone/devi/","devi");
		downloadFiles.put("http://szcdn1.ragalahari.com/feb2012/starzone/payal-gosh-blue-skirt-ragalahari-photo-session/", "payal-gosh-blue-skirt-ragalahari-photo-session");
		downloadFiles.put("https://starzone.ragalahari.com/june2011/starzone/nisha-gray-ragalahari-ps/", "nisha-gray-ragalahari-ps");

		downloadFiles.put("https://szcdn.ragalahari.com/mar2017/posters/ashwini-nuv-nenu-osey-orey-pm/", "ashwini-nuv-nenu-osey-orey-pm");
	downloadFiles.put("https://szcdn.ragalahari.com/jan2020/photosessions/gunjan-aras-mixed-jan2220-rps/", "gunjan-aras-mixed-jan2220-rps");
		
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/photosessions/vidya-vinod-indarkar/", "vidya-vinod-indarkar");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-vinod-indurkar-ragalahari-photoshoot/", "vidya-vinod-indurkar-ragalahari-photoshoot");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-indurkar-glam-stills/", "vidya-indurkar-glam-stills");
		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-vinod-indurkar-high-definition-photos/", "vidya-vinod-indurkar-high-definition-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/model-vidya-indurkar-blue-saree-photos/", "model-vidya-indurkar-blue-saree-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-indurkar-half-saree-stills/", "vidya-indurkar-half-saree-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2015/posters/vidya-vinod-indarkar-photo-gallery/", "vidya-vinod-indarkar-photo-gallery");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2014/starzone/vidya-sareedraping-workshop-by-dollyjain/", "vidya-sareedraping-workshop-by-dollyjain");
		
		downloadFiles.put("https://szcdn1.ragalahari.com/mar2012/starzone/bindu-spicy-hires/", "bindu-spicy-hires");
		downloadFiles.put("https://szcdn.ragalahari.com/july2012/starzone/tamakshi-ayomayam-apartment/", "tamakshi-ayomayam-apartment");
		downloadFiles.put("https://imgcdn.ragalahari.com/oct2014/photosessions/smitha-tiwari-photoshoot/", "smitha-tiwari-photoshoot");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2011/starzone/sannemadsen-spicy-photosession/", "sannemadsen-spicy-photosession");
		downloadFiles.put("https://szcdn.ragalahari.com/july2014/photosessions/indian-actress-tanusha/", "indian-actress-tanusha");		
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/photosessions/heroine-tanusha-glam-pics/", "heroine-tanusha-glam-pics");

*/		
//		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tanusha-swathi-in-pink-dress/", "tanusha-swathi-in-pink-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/august2009/starzone/waheeda5/", "waheeda52");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/vasavireddy/", "vasavireddy");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2022/photosessions/selina-green-sequin-bodycon-rps/", "selina-green-sequin-bodycon-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2022/photosessions/ankita-bhattacharya-photoshoot-jan2022/", "ankita-bhattacharya-photoshoot-jan2022");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2022/photosessions/prantika-das-brown-floral-mini-dress-rps/", "prantika-das-brown-floral-mini-dress-rps");
//		downloadFiles.put("https://img.ragalahari.com/jan2011/starzone/bhanu-sri-mehra-high-resolution-gallery/", "bhanu-sri-mehra-high-resolution-gallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/aashiroy-npfashions/", "aashiroy-npfashions");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2019/posters/ashi-roy-ks100-poster-launch/", "ashi-roy-ks100-poster-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2019/posters/ashi-roy-ks100-interview1/", "ashi-roy-ks100-interview");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2010/starzone/Aishwarya-Buridi-Heroine/", "Aishwarya-Buridi-Heroine");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2013/starzone/alekhya-gulabi-audio-release/", "alekhya-gulabi-audio-release");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/hd/amrutha-valli-hot-beach-shots/", "amrutha-valli-hot-beach-shots");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2020/hd/anveshijain-commitment-teaser-launch/", "anveshijain-commitment-teaser-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2020/hd/anveshi-jain-commitment-title-launch/", "anveshi-jain-commitment-title-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/hd/archana-high-definition/", "archana-high-definition");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/starzone/heroine-bhavisyika/", "heroine-bhavisyika");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2022/hd/dimple-hayathi-khiladi-press-meet/", "dimple-hayathi-khiladi-press-meet");
//		downloadFiles.put("https://szcdn.ragalahari.com/sep2019/hd/dimple-hayati-valmiki-pre-release/", "dimple-hayati-valmiki-pre-release");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2011/starzone/nisha-reddress-photogallery/", "nisha-reddress-photogallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2016/photosessions/shalini-hd-photoshoot-stills/", "shalini-hd-photoshoot-stills");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/sept2010/starzone/chapter-6-heroine-sonia-suri-photo-gallery/", "chapter-6-heroine-sonia-suri-photo-gallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2010/starzone/sunkashi-gallery4/", "sunkashi-gallery4");
//		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/starzone/vida-hot-pics/" , "vida-hot-pics");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2009/starzone/vainavi1/", " vainavi");
		
//		downloadFiles.put("https://starzone.ragalahari.com/may2009/starzone/vainavi1/", "vainavi1");
//		downloadFiles.put("https://starzone.ragalahari.com/june2008gallery/tanya1/", "tanya");
//		downloadFiles.put("https://starzone.ragalahari.com/june2008gallery/tanya1/", "tanya1");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/rekhasri1/", "rekhasri1");
//		downloadFiles.put("https://szcdn.ragalahari.com/december2008gallery/ruthika7/", "ruthika7");
//		downloadFiles.put("https://starzone.ragalahari.com/september2009/starzone/ruthika9/", "ruthika9");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2018/photosessions/actress-ruchira-in-black-dress/", "actress-ruchira-in-black-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2016/starzone/pragya-vangaveeti-event/", "pragya-vangaveeti-event");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2016/hd/pooja-misra-hot-photoshoot/", "pooja-misra-hot-photoshoot");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2022/hd/nitya-naresh-luzo-box-launch/", "nitya-naresh-luzo-box-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/posters/nitya-naresh-naveen-vijayakrishna-film-muhurat/", "nitya-naresh-naveen-vijayakrishna-film-muhurat");
//		downloadFiles.put("https://szcdn1.ragalahari.com/mar2013/posters/sunaina-in-samar/", "sunaina-in-samar");
//		downloadFiles.put("https://starzone.ragalahari.com/july2009/starzone/srilekhatwo1/", "srilekhatwo");
//		downloadFiles.put("https://img.ragalahari.com/dec2009/starzone/sonusharma2/", "sonusharma2");
//		downloadFiles.put("https://szcdn1.ragalahari.com/dec2012/photosessions/sri-chandana-spicy-photos/", "sri-chandana-spicy-photos");
//		downloadFiles.put("https://szcdn1.ragalahari.com/aug2012/photosessions/srichandana-black-gown-spicy-photos/", "srichandana-black-gown-spicy-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2009/starzone/arthipuri9/", "arthipuri9");
//		downloadFiles.put("https://img.ragalahari.com/feb2010/starzone/arthipuri12/", "arthipuri12");
//		downloadFiles.put("https://szcdn.ragalahari.com/september2009/starzone/arthipuri7/", "arthipuri7");
//		downloadFiles.put("https://starzone.ragalahari.com/june2009/starzone/arthipuri5/", "arthipuri5");
//		downloadFiles.put("https://starzone.ragalahari.com/may2009/starzone/arthipuri4/", "arthipuri4");
//		downloadFiles.put("https://starzone.ragalahari.com/may2011/starzone/arthi-puri-high-resolution/", "arthi-puri-high-resolution");
//		downloadFiles.put("https://starzone.ragalahari.com/may2011/starzone/arthi-puri-high-resolution-sanghatana-muhurat/", "arthi-puri-high-resolution-sanghatana-muhurat");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2009/starzone/arthipuri11/", "arthipuri11");
//		downloadFiles.put("https://starzone.ragalahari.com/may2014/hd/heroine-chaarulatha-hot-pics/", "heroine-chaarulatha-hot-pics");
//		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/heroine-chaarulatha/", "heroine-chaarulatha");
//		downloadFiles.put("https://starzone.ragalahari.com/june2016/photosessions/indian-filmactress-shunaya-solanki/", "indian-filmactress-shunaya-solanki");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2020/photosessions/shunaya-solanki-yellow-croptop-slit-skirt-rps/", "shunaya-solanki-yellow-croptop-slit-skirt-rps");
//		downloadFiles.put("https://img.ragalahari.com/feb2010/starzone/shehatwo1/", "shehatwo1");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2010/starzone/sneha-spicy-gallery/", "sneha-spicy-gallery");
//		downloadFiles.put("https://img.ragalahari.com/gallery/ramya5/", "ramya5");
//		downloadFiles.put("https://starzone.ragalahari.com/december2008gallery/ramya(3)8/", "ramya(3)8");
//		downloadFiles.put("https://starzone.ragalahari.com/january2009gallery/starzone/ramyathree8/", "ramyathree8");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/hd/ashi-roy-indian-silk-expo/", "ashi-roy-indian-silk-expo");
//		downloadFiles.put("https://starzone.ragalahari.com/june2010/starzone/Spoorthi-Das6/", "Spoorthi-Das6");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2010/starzone/spoorthi-das-saree-session/", "spoorthi-das-saree-session");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2011/starzone/spoorthi-ragalahari-photo-session/", "spoorthi-ragalahari-photo-session");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2010/starzone/spoorthi-das-spicy-session/", "spoorthi-das-spicy-session");
//		downloadFiles.put("https://starzone.ragalahari.com/april2010/starzone/spoorthidas4/", "spoorthidas4");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2010/starzone/spoorthi-das-photo-session8/", "spoorthi-das-photo-session8");
//		downloadFiles.put("https://starzone.ragalahari.com/august2009/starzone/taslimasheik2/", "taslimasheik2");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2018/photosessions/sanjananaidu-spicy-photoshoot/", "sanjananaidu-spicy-photoshoot");
//		downloadFiles.put("https://imgcdn.ragalahari.com/may2015/posters/saritha-cuba-libre-may29-2015/", "saritha-cuba-libre-may29-2015");
//		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/telangana-model-saritha/", "telangana-model-saritha");
//		downloadFiles.put("https://imgcdn.ragalahari.com/july2015/hd/gehana-high-definition/", "gehana-high-definition");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/photosessions/vandana-vasisth-spicy-pics/", "vandana-vasisth-spicy-pics");
//		downloadFiles.put("https://szcdn1.ragalahari.com/feb2013/photosessions/vandana-vasisth-ragalahari-shoot/", "vandana-vasisth-ragalahari-shoot");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2015/photosessions/gehana_vasisth_ragalahari_pics/", "gehana_vasisth_ragalahari_pics");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/photosessions/gehana-vasisth-photoshoot-red-dress/", "gehana-vasisth-photoshoot-red-dress");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/photosessions/gehana-vasisth-photoshoot-red-dress/", "gehana-vasisth-photoshoot-red-dress");
//		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/photosessions/shalini/", "shalini");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2013/photosessions/seethal-sidge-ragalahari-hot-photos/", "seethal-sidge-ragalahari-hot-photos");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2013/photosessions/seethal-sidge-hot-spicy-pics/", "seethal-sidge-hot-spicy-pics");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2015/photosessions/seethal-sidge-2015-photos/", "seethal-sidge-2015-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2014/photosessions/seethal-sidge-glam-shoot/", "seethal-sidge-glam-shoot");
//		downloadFiles.put("https://starzone.ragalahari.com/may2014/photosessions/seethal-sidge-ragalahari-photos/", "seethal-sidge-ragalahari-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/april2013/starzone/seethal-sidge-spicy-stills/", "seethal-sidge-spicy-stills");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2013/hd/ritukaur-gurudu-red-skirt/", "ritukaur-gurudu-red-skirt");
//		downloadFiles.put("https://szcdn1.ragalahari.com/jan2013/posters/ritu-kaur-hot-spicy-pics/", "ritu-kaur-hot-spicy-pics");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2013/posters/heroine-gurudu-ritu/", "heroine-gurudu-ritu");
//		downloadFiles.put("https://imgcdn.ragalahari.com/dec2013/posters/ritukaur-dancing-in-red-saree/", "ritukaur-dancing-in-red-saree");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2013/hd/ritu-kaur-hot-stills/", "ritu-kaur-hot-stills");
//		downloadFiles.put("https://szcdn1.ragalahari.com/jan2013/hd/gurudu-heroine-ritu-kaur-hd/", "gurudu-heroine-ritu-kaur-hd");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/posters/ritu-kaur-in-saree/", "ritu-kaur-in-saree");
//		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/vidarsha-manushalato-jagratha-audio/", "vidarsha-manushalato-jagratha-audio");
//		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/vidarsha-manushalato-jagratha-audio-sm/", "vidarsha-manushalato-jagratha-audio-sm");
//		downloadFiles.put("https://starzone.ragalahari.com/july2013/starzone/vidharsha-manushalato-jagratha-pm/", "vidharsha-manushalato-jagratha-pm");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2012/posters/sumitha-spicy-posters/", "sumitha-spicy-posters");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2012/hd/kavya-singh-hot-saree/", "kavya-singh-hot-saree");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2012/hd/kavya-singh-spicy/", "kavya-singh-spicy");
//		downloadFiles.put("https://starzone.ragalahari.com/april2013/starzone/kavya-singh-half-boil-audio/", "kavya-singh-half-boil-audio");
//		downloadFiles.put("https://szcdn1.ragalahari.com/april2013/hd/anusmriti-sarkar-hot/", "anusmriti-sarkar-hot");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2014/photosessions/anu-smriti-sarkar-in-pink-dress/", "anu-smriti-sarkar-in-pink-dress");
//		downloadFiles.put("https://media.ragalahari.com/march2009/starzone/sidhie4/", "sidhie4");
//		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/sidhie9/", "sidhie9");
//		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/roopakaur8/", "roopakaur8");
//		downloadFiles.put("https://starzone.ragalahari.com/december2008gallery/roopakaur6/", "roopakaur6");
//		downloadFiles.put("https://starzone.ragalahari.com/january2009gallery/starzone/roopakaur7/", "roopakaur7");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2016/photosessions/telugu-actress-chaitanya-photos/", "telugu-actress-chaitanya-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2022/hd/tejaswi-madiwada-commitment-interview/", "tejaswi-madiwada-commitment-interview");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2016/photosessions/actress-chaitanya-saree-stills/", "actress-chaitanya-saree-stills");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2016/photosessions/chaitanya-telugu-actress-photos/", "chaitanya-telugu-actress-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2022/hd/chaithanya-priya-purna-movie-launch/", "chaithanya-priya-purna-movie-launch");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2018/hd/charishma-shreekar-trendz-exhibition/", "charishma-shreekar-trendz-exhibition");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2018/starzone/charishma-shreekar-neethonehaihai/", "charishma-shreekar-neethonehaihai");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2018/hd/charishma-shreekar-akrittielite-launch/", "charishma-shreekar-akrittielite-launch");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2022/photosessions/pranjal-palkar-white-floral-dress-rps/", "pranjal-palkar-white-floral-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2021/photosessions/pranjal-palkar-light-pink-dress-rps/", "pranjal-palkar-light-pink-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2022/photosessions/aparna-mallik-orange-half-saree-rps/", "aparna-mallik-orange-half-saree-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2021/photosessions/aparnna-orange-half-placket-crop-top-rps/", "aparnna-orange-half-placket-crop-top-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2012/posters/aasheeka-bathija-long-skirt-posters/", "aasheeka-bathija-long-skirt-posters");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2011/starzone/aashika-at-santhoshampm-highresolution/", "aashika-at-santhoshampm-highresolution");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/photosessions/siya-gautham-pink-floral-mini-dress-rps/", "siya-gautham-pink-floral-mini-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/photosessions/siya-gautham-pink-floral-mini-dress-rps/", "siya-gautham-pink-floral-mini-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/may2009/starzone/arora1/", "arora1");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2022/hd/dimple-hayati-photoshoot-aug2022/", "dimple-hayati-photoshoot-aug2022");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2014/photosessions/zeba-khan-ragalahari-photos/", "zeba-khan-ragalahari-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2016/photosessions/shalini-glam-stills-in-shorts/", "shalini-glam-stills-in-shorts");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2014/photosessions/shalini/", "shalini");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2012/photosessions/anjali-dwivedi-exclusive-studio-shoot/", "anjali-dwivedi-exclusive-studio-shoot");
//		downloadFiles.put("https://szcdn1.ragalahari.com/mar2012/starzone/anjali-dwivedi-ragalahari-session/", "anjali-dwivedi-ragalahari-session");
//		downloadFiles.put("https://szcdn1.ragalahari.com/oct2012/photosessions/anjali-dwivedi-hot-sleeveless-dress/", "anjali-dwivedi-hot-sleeveless-dress");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/hd/menaka-hot-photoshoot-hd/", "menaka-hot-photoshoot-hd");
//		downloadFiles.put("https://szcdn1.ragalahari.com/mar2013/posters/menaka-spicy-saree/", "menaka-spicy-saree");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2011/starzone/ayesha-blackdress-photosession/", "ayesha-blackdress-photosession");
//		downloadFiles.put("https://starzone.ragalahari.com/april2011/starzone/ayesha2-blackdress-ragalahari-photosession/", "ayesha2-blackdress-ragalahari-photosession");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2011/starzone/ayesha2-orange-dress-ragalahari-ps/", "ayesha2-orange-dress-ragalahari-ps");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2011/starzone/ayesha2-black-shirt-ragalahari-ps/", "ayesha2-black-shirt-ragalahari-ps");
//		downloadFiles.put("https://starzone.ragalahari.com/april2016/photosessions/priya-singh-ragalahari-photoshoot/", "priya-singh-ragalahari-photoshoot");
//		downloadFiles.put("https://starzone.ragalahari.com/december2008gallery/ramya(3)8/", "ramya(3)8");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2015/posters/ramya-loafer-success-meet/", "ramya-loafer-success-meet");
//		downloadFiles.put("https://starzone.ragalahari.com/april2017/hd/shunaya-solanki-hot-stills/", "shunaya-solanki-hot-stills");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/sindhura-rout-heroine/", "sindhura-rout-heroine");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2016/photosessions/sindhura-rout-ragalahari/", "sindhura-rout-ragalahari");
/*
		downloadFiles.put("https://starzone.ragalahari.com/oct2016/photosessions/model-sindura-rout-hd-wallpapers/", "model-sindura-rout-hd-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/mar2017/photosessions/sindhura-rout-hd-glam-photos/", "sindhura-rout-hd-glam-photos");
		downloadFiles.put("https://starzone.ragalahari.com/june2020/hd/sindura-rout-june2020/", "sindura-rout-june2020");
		downloadFiles.put("https://starzone.ragalahari.com/mar2020/hd/sindhura-rout-naakide-first-time-audio/", "sindhura-rout-naakide-first-time-audio");
		downloadFiles.put("https://starzone.ragalahari.com/april2017/photosessions/sindhura-rout-in-pink-dress-hd-photos/", "sindhura-rout-in-pink-dress-hd-photos");
*/		
/*
		downloadFiles.put("https://starzone.ragalahari.com/aug2021/hd/gehna-vasishta-photoshoot-aug2021/", "gehna-vasishta-photoshoot-aug2021");
		downloadFiles.put("https://starzone.ragalahari.com/oct2020/hd/gehana-vasisth-oct2020/", "gehana-vasisth-oct2020");
		downloadFiles.put("https://starzone.ragalahari.com/sep2020/starzone/gehana-vasisth-red-bikini-sep2020/", "gehana-vasisth-red-bikini-sep2020");
		downloadFiles.put("https://starzone.ragalahari.com/may2020/hd/gehana-vasisth-fabglam-studios-may2020/", "gehana-vasisth-fabglam-studios-may2020");
		downloadFiles.put("https://starzone.ragalahari.com/may2020/starzone/gehana-vasisth-may2020/", "gehana-vasisth-may2020");
		downloadFiles.put("https://starzone.ragalahari.com/dec2019/hd/gehana-vasisth-arabic-song/", "gehana-vasisth-arabic-song");
		downloadFiles.put("https://starzone.ragalahari.com/nov2019/hd/gehna-vasishta-photoshoot-nov2719/", "gehna-vasishta-photoshoot-nov2719");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/gehana-vasisth-red/", "gehana-vasisth-red");
		downloadFiles.put("https://starzone.ragalahari.com/mar2018/starzone/gehana-vasist-private-pictures/", "gehana-vasist-private-pictures");
		downloadFiles.put("https://starzone.ragalahari.com/mar2018/hd/gehana-vasisth-stills/", "gehana-vasisth-stills");
		downloadFiles.put("https://starzone.ragalahari.com/aug2017/starzone/gehana-vasisth-bollywood/", "gehana-vasisth-bollywood");
		downloadFiles.put("https://starzone.ragalahari.com/may2017/hd/gehana-vasisth-latest-portfolio/", "gehana-vasisth-latest-portfolio201");
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/starzone/gehana-vasisth-innerwear/", "gehana-vasisth-innerwear");
		downloadFiles.put("https://starzone.ragalahari.com/oct2016/starzone/gehana-vasisth-latest-photos/", "gehana-vasisth-latest-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2016/starzone/gehana/", "gehana");
		downloadFiles.put("https://starzone.ragalahari.com/july2016/posters/gehna-vasisth-poolside-pics/", "gehna-vasisth-poolside-pics");
		downloadFiles.put("https://starzone.ragalahari.com/june2016/starzone/gehana-vasisth-in-chudidar/", "gehana-vasisth-in-chudidar");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/bollywood-gehana-vasisth-glam-stills/", "bollywood-gehana-vasisth-glam-stills");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/starzone/gehana-vasisth-golden-dress/", "gehana-vasisth-golden-dress");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/gehana-vasisth-in-blue-saree-hd/", "gehana-vasisth-in-blue-saree-hd");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/gehana-vasisth-red-hd-stills/", "gehana-vasisth-red-hd-stills");
		downloadFiles.put("https://starzone.ragalahari.com/aug2015/photosessions/gehana_vasisth_ragalahari_pics/", "gehana_vasisth_ragalahari_pics");
		downloadFiles.put("https://starzone.ragalahari.com/oct2015/starzone/gehana/", "gehana");
		downloadFiles.put("https://starzone.ragalahari.com/july2015/photosessions/gehana-vasisth-hottest-photoshoot/", "gehana-vasisth-hottest-photoshoot");
		downloadFiles.put("https://starzone.ragalahari.com/july2015/photosessions/savita-barbie-actress-gehana-vasisth-photos/", "savita-barbie-actress-gehana-vasisth-photos");
		downloadFiles.put("https://starzone.ragalahari.com/aug2015/starzone/gehna-vashisht-glam-stills/", "gehna-vashisht-glam-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/photosessions/gehana-vasisth-photoshoot-red-dress/", "gehana-vasisth-photoshoot-red-dress");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/gehana-photos/", "gehana-photos");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/hd/gehana-vasisth-high-definition/", "gehana-vasisth-high-definition");
		downloadFiles.put("https://starzone.ragalahari.com/april2015/starzone/gehana/", "gehana");
		downloadFiles.put("https://imgcdn.ragalahari.com/may2015/photosessions/kollywood-actress-gehana-vasisth-ragalahari/", "kollywood-actress-gehana-vasisth-ragalahari");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/gehana-pics/", "gehana-pics");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/gehana/", "gehana");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/gehna-vasisth-bluemoon/", "gehna-vasisth-bluemoon");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/gehana-vasisth/", "gehana-vasisth");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/gehana-vasisth-lucknowi-ishq/", "gehana-vasisth-lucknowi-ishq");
//		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/hd/gehana/", "gehana");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/hd/gehana-vasisth-hd-photos/", "gehana-vasisth-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/oct2014/photosessions/chhattisgarh-actress-gehana-vasisth/", "chhattisgarh-actress-gehana-vasisth");
		downloadFiles.put("https://starzone.ragalahari.com/oct2014/starzone/gehana-vaisth-in-saree/", "gehana-vaisth-in-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2014/hd/gehana-vasisth-in-pink-dress/", "gehana-vasisth-in-pink-dress");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/starzone/gehana-vasisth-shoot/", "gehana-vasisth-shoot");
		downloadFiles.put("https://starzone.ragalahari.com/jan2014/photosessions/bollywood-actress-gehana-vasisth/", "bollywood-actress-gehana-vasisth");
		downloadFiles.put("https://starzone.ragalahari.com/jan2014/starzone/gehna-vashisht-fncc-2014-celebrations/", "gehna-vashisht-fncc-2014-celebrations");
		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/photosessions/gehna-vashisht-twitter-hot-photos/", "gehna-vashisht-twitter-hot-photos");
		
		downloadFiles.put("https://starzone.ragalahari.com/aug2013/starzone/heroine-gehna/", "heroine-gehna");
		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/photosessions/vandana-vasisth-spicy-pics/", "vandana-vasisth-spicy-pics");
		downloadFiles.put("https://starzone.ragalahari.com/july2013/starzone/gehna-vashisht-hot-pics/", "gehna-vashisht-hot-pics");
		downloadFiles.put("https://starzone.ragalahari.com/july2013/starzone/vandanavasisth-parinaya-wedding-fair/", "vandanavasisth-parinaya-wedding-fair");
		downloadFiles.put("https://starzone.ragalahari.com/june2013/starzone/vandana-vasisth-black-dress/", "vandana-vasisth-black-dress");
		downloadFiles.put("https://starzone.ragalahari.com/april2013/starzone/vandana-vasisth-hyderabad-sunrisers/", "vandana-vasisth-hyderabad-sunrisers");
		downloadFiles.put("https://szcdn1.ragalahari.com/feb2013/photosessions/vandana-vasisth-ragalahari-shoot/", "vandana-vasisth-ragalahari-shoot");
		
		downloadFiles.put("https://starzone.ragalahari.com/june2014/starzone/vandana-vashisht-33premakathalu-audio/", "vandana-vashisht-33premakathalu-audio");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2016/starzone/gehana/", "gehana");
		downloadFiles.put("https://szcdn1.ragalahari.com/feb2013/photosessions/vandana-vasisth-ragalahari-shoot/", "vandana-vasisth-ragalahari-shoot");
		downloadFiles.put("https://starzone.ragalahari.com/jan2013/starzone/vandana-vasisth-symphony-music-academy/", "vandana-vasisth-symphony-music-academy");
*/		
/*		
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/priyanka-augustin-hd-wallpapers/","priyanka-augustin-hd-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/mar2017/photosessions/priyanka-augustin-pink-blue-dress/","priyanka-augustin-pink-blue-dress");
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/posters/priya-at-pochampally-ikat-artmela/","priya-at-pochampally-ikat-artmela");
		downloadFiles.put("https://starzone.ragalahari.com/june2017/photosessions/priyanka-augustin-in-half-saree/","priyanka-augustin-in-half-saree");
		downloadFiles.put("https://starzone.ragalahari.com/june2021/photosessions/priyanka-augustin-yellow-divided-skirt-rps/","priyanka-augustin-yellow-divided-skirt-rps");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/starzone/priya-augustin-yellow-dress/","priya-augustin-yellow-dress100");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/proia-augustin-long-frock-hd-photos/","proia-augustin-long-frock-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-red-shirt-denim-shorts-rps/","priyanka-augustin-red-shirt-denim-shorts-rps");
		downloadFiles.put("https://starzone.ragalahari.com/july2019/posters/priya-augustin-mass-power-50days/","priya-augustin-mass-power-50days");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/proia-augustin-long-frock-hd-photos/","proia-augustin-long-frock-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/photosessions/priyanka-augustin-traditional-diya-rps/","priyanka-augustin-traditional-diya-rps");
		downloadFiles.put("https://starzone.ragalahari.com/dec2020/hd/priya-augustin-super-power-trailer/", "priya-augustin-super-power-trailer");
		downloadFiles.put("https://starzone.ragalahari.com/april2019/hd/priya-augustin-runam-pm/", "priya-augustin-runam-pm");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/feb2015/photosessions/manisha-pillai-ragalahari/", "manisha-pillai-ragalahari");
//		downloadFiles.put("https://starzone.ragalahari.com/august2009/starzone/waheeda5/", "waheeda");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/feb2017/photosessions/priyanka-augustin-hd-pics-in-blue-dress/", "priyanka-augustin-hd-pics-in-blue-dress");
		downloadFiles.put("https://starzone.ragalahari.com/dec2017/starzone/priyanka-augustin-red-dress/", "priyanka-augustin-red-dress");
		downloadFiles.put("https://starzone.ragalahari.com/june2018/hd/priya-augustin-wallpapers/", "priya-augustin-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/june2018/starzone/priyanka-augustin-saree/", "priyanka-augustin-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2018/starzone/augustin-priya/","augustin-priya");
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/model-priyanka-augustin-hd-photos/","model-priyanka-augustin-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/mar2018/posters/priya-augustin-jawedhabib-salon-launch/","priya-augustin-jawedhabib-salon-launch");
		downloadFiles.put("https://starzone.ragalahari.com/feb2018/posters/priya-augustin-blue-saree/","priya-augustin-blue-saree");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-white-stripes-top-shorts-rps/","priyanka-augustin-white-stripes-top-shorts-rps");		
		downloadFiles.put("https://starzone.ragalahari.com/aug2014/starzone/manisha-kanyarajsons/","manisha-kanyarajsons");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/photosessions/manisha-pillai-ragalahari-photos/","manisha-pillai-ragalahari-photos");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/model-manisha-pillai/","model-manisha-pillai");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/photosessions/manisha-pillai-ragalahari-glam-stills/","manisha-pillai-ragalahari-glam-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/may2015/posters/manisha-pilla-item-song/","manisha-pilla-item-song");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/manisha-pillai/","manisha-pillai");
		downloadFiles.put("https://starzone.ragalahari.com/july2015/hd/manisha-pillai-high-definition/","manisha-pillai-high-definition");		
		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/manisha-pillai-pics/","manisha-pillai-pics");				
		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/manisha-pillai-wallpapers/","manisha-pillai-wallpapers");		
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/starzone/manisha-pillai-club-republic/","manisha-pillai-club-republic");		
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/starzone/manisha-pillai-club-republic-photos/","manisha-pillai-club-republic-photos");		
		downloadFiles.put("https://starzone.ragalahari.com/nov2015/starzone/manisha-pillai/","manisha-pillai");				
		downloadFiles.put("https://starzone.ragalahari.com/dec2015/posters/manisha-pillai-saree-stills/","manisha-pillai-saree-stills");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/starzone/manisha-pillai-traditional-queen/","manisha-pillai-traditional-queen");		
		downloadFiles.put("https://starzone.ragalahari.com/feb2016/starzone/manisha-pillai-kismet-pub/","manisha-pillai-kismet-pub");
		downloadFiles.put("https://starzone.ragalahari.com/feb2016/photosessions/manisha-pillai-pics/","manisha-pillai-pics");		
		downloadFiles.put("https://starzone.ragalahari.com/may2017/posters/manisha-pillai-akriti-exhibition/","manisha-pillai-akriti-exhibition");
		downloadFiles.put("https://starzone.ragalahari.com/july2017/starzone/manisha-pillai/","manisha-pillai");		
		downloadFiles.put("https://starzone.ragalahari.com/aug2020/hd/manisha-pillai-aug2020/","manisha-pillai-aug2020");
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/hd/manisha-pillai-nov1320/","manisha-pillai-nov1320");		
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/hd/manisha-pillai-pink-lehenga/","manisha-pillai-pink-lehenga");		
		downloadFiles.put("https://starzone.ragalahari.com/dec2020/hd/manisha-pillai/","manisha-pillai");		
		downloadFiles.put("https://starzone.ragalahari.com/feb2021/hd/sadhana-pillai-white-dress/","sadhana-pillai-white-dress");		
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/photosessions/manisha-pillai-actress-ragalahari/","manisha-pillai-actress-ragalahari");		
		downloadFiles.put("https://starzone.ragalahari.com/oct2012/hd/kavya-singh-hot-masala/","kavya-singh-hot-masala");		
		downloadFiles.put("https://starzone.ragalahari.com/oct2011/starzone/shravya-reddy-highres-portfolio/","shravya-reddy-highres-portfolio");		
		downloadFiles.put("https://szcdn.ragalahari.com/june2012/starzone/shravya-reddy-highres/","shravya-reddy-highres");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/starzone/shravya-reddy-nri-audio/","shravya-reddy-nri-audio");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/photosessions/shravya-reddy-short-prom-dress/","shravya-reddy-short-prom-dress");		
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/starzone/shravya-reddy-heroine-nri/","shravya-reddy-heroine-nri");		
		downloadFiles.put("https://szcdn1.ragalahari.com/dec2012/photosessions/shravya-reddy-studio-shoot/","shravya-reddy-studio-shoot");		
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/posters/shravya-reddy-red-dress/","shravya-reddy-red-dress");		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/starzone/shravya-reddy-aey-audio-release/","shravya-reddy-aey-audio-release");		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/starzone/shravya-reddy-hotel-golden-park/","shravya-reddy-hotel-golden-park");		
		downloadFiles.put("https://szcdn.ragalahari.com/feb2013/starzone/shravya-reddy-neerus-designer-embroidery/","shravya-reddy-neerus-designer-embroidery");		
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/hd/nri-movie-heroine-shravya-reddy/","nri-movie-heroine-shravya-reddy");		
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/shravya-reddy-nri-platinum-disc/","shravya-reddy-nri-platinum-disc");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/photosessions/shravya-reddy-black-dress/","shravya-reddy-black-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shravya-reddy-mozarella/","shravya-reddy-mozarella");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shraavya-reddy-portfolio-pics/","shraavya-reddy-portfolio-pics");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/starzone/shravya-reddy-sleepwell/","shravya-reddy-sleepwell");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shravya-sasya-summer-wedding-line-launch/", "shravya-sasya-summer-wedding-line-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/june2013/starzone/shravya-reddy-at-sundown2-aqua/", "shravya-reddy-at-sundown2-aqua");
		downloadFiles.put("https://img.ragalahari.com/june2013/starzone/shravyareddy-hyderabad-fashion-week/", "shravyareddy-hyderabad-fashion-week");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/shravya-reddy-rainbow-shopping/", "shravya-reddy-rainbow-shopping");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2013/posters/heroine-sravya-reddy/", "heroine-sravya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/shravya-reddy-melange-exhibition-2013/", "shravya-reddy-melange-exhibition-2013");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/starzone/eyy-heroine-shravya-reddy/", "eyy-heroine-shravya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/hd/shravyareddy-hiya-varalakshmi-vratam/", "shravyareddy-hiya-varalakshmi-vratam");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2013/starzone/shravya-reddy-radisson-blu/", "shravya-reddy-radisson-blu");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2013/starzone/shravya-reddy-vasanthayanam-pressmeet/", "shravya-reddy-vasanthayanam-pressmeet");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/starzone/shravya-reddy-at-fashion-show-at-spoil/", "shravya-reddy-at-fashion-show-at-spoil");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2014/starzone/hyderabad-heroine-sravya-reddy/", "hyderabad-heroine-sravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/sravya-reddy-hot/", "sravya-reddy-hot");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/starzone/shravyareddy-tasyaah-awareness-fashion-walk/", "shravyareddy-tasyaah-awareness-fashion-walk");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/starzone/sravya-reddy-portfolio/", "sravya-reddy-portfolio");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-veerudokkade-audio/", "shravya-reddy-veerudokkade-audio");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2014/starzone/shravya-reddy-op-everest-in-pictures/", "shravya-reddy-op-everest-in-pictures");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/starzone/shravya-reddy-at-premaloabc-audio/", "shravya-reddy-at-premaloabc-audio");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-kismet-march21-2014/", "shravya-reddy-kismet-march21-2014");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-vijaya-rana-franchise-launch/", "shravya-reddy-vijaya-rana-franchise-launch");
		downloadFiles.put("https://imgcdn.ragalahari.com/aug2014/starzone/heroine-shravya-reddy/", "heroine-shravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/posters/shraavya-reddy/", "shraavya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/starzone/shraavya-reddy-in-white-dress/", "shraavya-reddy-in-white-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/posters/shraavya-reddy-heroine/shraavya-reddy-heroine1t.jpg", "heroine-shravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/starzone/shravyareddy/", "shravyareddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/shravya-reddy-hyderabad-actress/", "shravya-reddy-hyderabad-actress");
		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/sravya-reddy-hot-stills/", "sravya-reddy-hot-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/photosessions/sravya-reddy-raagalahari/", "sravya-reddy-raagalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/hd/heroine-shravya-hot-pics/", "heroine-shravya-hot-pics");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/shravyareddy-stateart-gallery/", "shravyareddy-stateart-gallery");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/hd/shravya-reddy-high-definition-photos/", "shravya-reddy-high-definition-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2017/posters/shravya-reddy-balakrishnudu-pre-release/", "shravya-reddy-balakrishnudu-pre-release");
		downloadFiles.put("https://szcdn.ragalahari.com/june2017/posters/shravya-reddy-hq-stills-in-red-dress/", "shravya-reddy-hq-stills-in-red-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2017/hd/shravya-reddy-rogue-teaser-launch/", "shravya-reddy-rogue-teaser-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/posters/shravya-reddy-diwali-hq-photos/", "shravya-reddy-diwali-hq-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shraavya-reddy-green-pleated-jumpsuit-rps/", "shraavya-reddy-green-pleated-jumpsuit-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shravya-reddy-mint-green-saree-rps/", "shravya-reddy-mint-green-saree-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shravya-reddy-purple-dress-rps/", "shravya-reddy-purple-dress-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2018/hd/shraavya-reddy-vastaa-genesis-cr/", "shraavya-reddy-vastaa-genesis-cr");
		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/teertha4/", "teertha4");
		downloadFiles.put("https://szcdn.ragalahari.com/august2009/starzone/teertha8/", "teertha8");
		downloadFiles.put("https://starzone.ragalahari.com/dec2017/hd/geet-shah-yellow-saree/", "geet-shah-yellow-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2017/photosessions/monica-thompson-red-long-skirt/", "monica-thompson-red-long-skirt");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/monica-thompson-actress-hot-stills-ragalahari/", "monica-thompson-actress-hot-stills-ragalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/photosessions/tamil-actress-monica-thompson-photos/", "tamil-actress-monica-thompson-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/photosessions/monica-thompson-in-designer-dress/", "monica-thompson-in-designer-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/april2014/photosessions/mithuna-waliya-ragalahari-photos/", "mithuna-waliya-ragalahari-photos");
		downloadFiles.put("https://szcdn1.ragalahari.com/oct2013/photosessions/mithuna-waliya-hot-unseen-photos/", "mithuna-waliya-hot-unseen-photos");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2013/starzone/mithuna-waliya-lovejunction-platinum/", "mithuna-waliya-lovejunction-platinum");
		downloadFiles.put("https://szcdn.ragalahari.com/april2016/starzone/midhuna-in-saree-stills/", "midhuna-in-saree-stills");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/photosessions/vennilavin-arangetram-mithuna-waliya/", "vennilavin-arangetram-mithuna-waliya");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2015/hd/monica-thompson-hot-pics/", "monica-thompson-hot-pics");
		
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/pooja-sree-glam-photos/", "pooja-sree-glam-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/may2022/hd/eesha-rebba-shekar-trailer-launch/", "eesha-rebba-shekar-trailer-launch");
*/
//		downloadFiles.put("https://szcdn.ragalahari.com/april2017/photosessions/sindhura-rout-in-mini-frock-hd-stills/", "sindhura-rout-in-mini-frock-hd-stills");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/june2018/hd/priyanka-raman-lsilk-dezire-india2018/", "priyanka-raman-lsilk-dezire-india2018");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/april2018/hd/priyaraman-fibertosilk/", "priyaraman-fibertosilk");
//		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/sania-srivastav-highres/", "sania-srivastav-highres");
		
//		downloadFiles.put("https://imgcdn.ragalahari.com/july2015/posters/pakhi-hegde/", "pakhi-hegde");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/soniatwo1/", "soniatwo1");
//		downloadFiles.put("https://szcdn.ragalahari.com/march2009/starzone/yasmin/", "yasmin");
//		downloadFiles.put("https://szcdn.ragalahari.com/sep2022/photosessions/vrushali-green-sequin-peplum-top-rps/", "vrushali-green-sequin-peplum-top-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2017/photosessions/vrushaligosavi-ragalahari-studio-shoot/", "vrushaligosavi-ragalahari-studio-shoot");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2017/photosessions/vrushali-gosavi-teluguactress-photoshoot/", "vrushali-gosavi-teluguactress-photoshoot");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2017/starzone/vrushali-gosavi-follow-follow-you/", "vrushali-gosavi-follow-follow-you");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2018/photosessions/vrushali-gosavi-photoshoot/", "vrushali-gosavi-photoshoot");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2017/photosessions/tollywood-heroine-vrushali-gosavi/", "tollywood-heroine-vrushali-gosavi");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/photosessions/vrushali-gosavi-in-yellow-dress/", "vrushali-gosavi-in-yellow-dress");		
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/photosessions/vrushali-gosavi-hd-photos-in-blue-dress/", "vrushali-gosavi-hd-photos-in-blue-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/photosessions/vrushali-gosavi-in-pink-dress/", "vrushali-gosavi-in-pink-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/photosessions/vrushali-gosavi-half-saree/", "vrushali-gosavi-half-saree");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/starzone/vrushali-in-long-blue-skirt/", "vrushali-in-long-blue-skirt");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/posters/vrushali-gosavi-glitz-glam/", "vrushali-gosavi-glitz-glam");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2015/starzone/vrushali-sundarangudu-stills/", "vrushali-sundarangudu-stills");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2015/starzone/vrushali-srimathi-bangaram/", "vrushali-srimathi-bangaram");
//		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/starzone/vrushali/", "vrushali");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2015/hd/telugu-heroine-vrushali-ragalahari-photos/", "telugu-heroine-vrushali-ragalahari-photos");
//		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/starzone/heroine-vrushali/", "heroine-vrushali");
//		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/starzone/vrushali-at-book-cinema-launch/", "vrushali-at-book-cinema-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2014/starzone/telugu-heroine-vrushali-photos/", "telugu-heroine-vrushali-photos");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2014/starzone/model-vrushali-photos/", "model-vrushali-photos");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/june2018/photosessions/teja-reddy-in-short-jeans/", "teja-reddy-in-short-jeans");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2018/photosessions/teja-reddy-heroine-black-dress/", "teja-reddy-heroine-black-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2016/photosessions/actress-teja-reddy/", "actress-teja-reddy");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2016/photosessions/teja-reddy-ragalahari-photos/", "teja-reddy-ragalahari-photos");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2016/photosessions/teja-reddy-hd-wallpapers/", "teja-reddy-hd-wallpapers");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2017/hd/teja-reddy-blue-saree/","teja-reddy-blue-saree");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tashu-kaushik-shoulderless-yellow-dress/", "tashu-kaushik-shoulderless-yellow-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2016/photosessions/telugu-actress-teja-reddy-ragalahari-photos/", "telugu-actress-teja-reddy-ragalahari-photos");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2016/photosessions/teja-reddy-high-definition-photos/", "teja-reddy-high-definition-photos");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2016/photosessions/teja-reddy-glam-stills/", "teja-reddy-glam-stills");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2018/photosessions/teja-reddy-hd-wallpapers/", "teja-reddy-hd-wallpapers");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2022/photosessions/teja-reddy-blue-maxi-dress-rps/", "teja-reddy-blue-maxi-dress-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2022/photosessions/teja-reddy-green-long-slit-dress-rps/", "teja-reddy-green-long-slit-dress-rps");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/sep2019/hd/teja-reddy-beach-road-chetan-teaser/", "teja-reddy-beach-road-chetan-teaser");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2019/photosessions/teja-reddy-maroon-croptop-lehenga-rps/", "teja-reddy-maroon-croptop-lehenga-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2019/photosessions/teja-reddy-blue-printed-mini-dress-rps/","teja-reddy-blue-printed-mini-dress-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2019/photosessions/teja-reddy-peach-long-dress-rps/", "teja-reddy-peach-long-dress-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2019/photosessions/teja-reddy-white-floral-top-jeans-rps/", "teja-reddy-white-floral-top-jeans-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2019/photosessions/tejareddy-bule-saree-ragalahari-shoot/", "tejareddy-bule-saree-ragalahari-shoot");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2018/photosessions/teja-reddy-indo-western-style/", "teja-reddy-indo-western-style");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2018/photosessions/teja-reddy-polka-dots-pink-tshirt/", "teja-reddy-polka-dots-pink-tshirt");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2018/photosessions/telugu-actress-teja-reddy/", "telugu-actress-teja-reddy");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2018/starzone/teja-reddy-yellow-dress/", "teja-reddy-yellow-dress");		
//		downloadFiles.put("https://szcdn.ragalahari.com/april2018/photosessions/teja-reddy-in-mini-frock/", "teja-reddy-in-mini-frock");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2019/hd/teja-reddy-rudra-nagu-muhurat/", "teja-reddy-rudra-nagu-muhurat");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2016/photosessions/model-teja-reddy-photos/","model-teja-reddy-photos");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2011/starzone/tashu-kaushik-high-resolution-vykuntapali-pm/", "tashu-kaushik-high-resolution-vykuntapali-pm");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2022/hd/pavani-bhimeneni-hi-life-aug2022/", "pavani-bhimeneni-hi-life-aug2022");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2022/photosessions/deepika-chourasia-black-denim-jaket-rps/", "deepika-chourasia-black-denim-jaket-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2022/photosessions/ayesha-maroon-croptop-denim-shorts-rps/", "ayesha-maroon-croptop-denim-shorts-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2022/photosessions/aadhya-paruchuri-red-pallazoo-croptop-rps/", "aadhya-paruchuri-red-pallazoo-croptop-rps");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2022/photosessions/richa-kalra-black-top-denim-shorts-rps/", "richa-kalra-black-top-denim-shorts-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2016/starzone/aliya-singh-krasna-launch/", "aliya-singh-krasna-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/photosessions/akshayarao-in-black-top/", "akshayarao-in-black-top");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2015/photosessions/akshaya-rao-actress-ragalahari/", "akshaya-rao-actress-ragalahari");
		
//		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/akshaya-rao-actress/", "akshaya-rao-actress");
//		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/akshayarao-in-blackdress/", "akshayarao-in-blackdress");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2011/starzone/nakantu-okkaru-heroine-akshaya/", "nakantu-okkaru-heroine-akshaya");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/garima-sing-pvr-arts-movie-launch/", "garima-sing-pvr-arts-movie-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/anchor-indu-love-you-ram-teaser-launch/", "anchor-indu-love-you-ram-teaser-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2020/photosessions/anchor-indu-gray-griller-knit-dress-rps/", "anchor-indu-gray-griller-knit-dress-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2013/starzone/pallavisreshta-okahindu-okamuslim/", "pallavisreshta-okahindu-okamuslim");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/sirisha-photo-gallery/", "sirisha-photo-gallery");
//		downloadFiles.put("https://starzone.ragalahari.com/december2008gallery/sindhuri5/", "sindhuri5");
//		downloadFiles.put("https://imgcdn.ragalahari.com/july2014/photosessions/telugu-tv-actress-shiny/", "telugu-tv-actress-shiny");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2015/photosessions/smily/", "smily");
//		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/photosessions/indian-model-smily-glam-shoot/", "indian-model-smily-glam-shoott");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/hd/smily-ragalahari-hd-portfolio/", "smily-ragalahari-hd-portfolio");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/photosessions/model-smily/", "model-smily");
/*		
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/sneha-thakur-spicy-pics/", "sneha-thakur-spicy-pics");
		
		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/hd/siri-sri-ee-cinema-superhit-guarantee/", "siri-sri-ee-cinema-superhit-guarantee");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2012/starzone/sree-siri-traditional-gallery/", "sree-siri-traditional-gallery");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2014/starzone/siri-chakkiligintha-audio/", "siri-chakkiligintha-audio");
		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/sirisri-broker2-on-the-sets/", "sirisri-broker2-on-the-sets");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2012/starzone/sree-siri-photogallery/", "sree-siri-photogallery");
		downloadFiles.put("https://szcdn.ragalahari.com/july2011/starzone/sree-siri-high-resolution/", "sree-siri-high-resolution");
*/		
		/*		
		downloadFiles.put("https://szcdn.ragalahari.com/feb2014/photosessions/sarada-rani-ragalahari-photo-shoot/","sarada-rani-ragalahari-photo-shoot");
		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/photosessions/sarada-rani-hot-photoshoot/", "sarada-rani-hot-photoshoot"	);
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/photosessions/sarada-rani-ragalahari-photos/", "sarada-rani-ragalahari-photos");
		downloadFiles.put("https://starzone.ragalahari.com/oct2014/photosessions/akshaya-rao-half-saree/", "akshaya-rao-half-saree");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2014/photosessions/heroine-akshaya-rao/", "heroine-akshaya-rao");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2019/posters/nandini-ks-100-audio-launch/", "nandini-ks-100-audio-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/photosessions/geeta-half-saree-shoot/", "geeta-half-saree-shoot");
		downloadFiles.put("https://szcdn.ragalahari.com/april2014/photosessions/hyderabad-hot-model-madhuri/", "hyderabad-hot-model-madhuri");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/photosessions/hyderabad-model-madhuri-saree-shoot/", "hyderabad-model-madhuri-saree-shoot");
		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/photosessions/telugu-girl-madhuri/", "telugu-girl-madhuri");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/photosessions/model-madhuri-pink-dress-ragalahari/", "model-madhuri-pink-dress-ragalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/photosessions/madhuri-photoshoot/", "madhuri-photoshoot");
/*		downloadFiles.put("https://starzone.ragalahari.com/april2018/starzone/priya-augustin-yellow-dress/","priya-augustin-yellow-dress10");		
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/priyanka-augustin-hd-wallpapers/","priyanka-augustin-hd-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/mar2017/photosessions/priyanka-augustin-pink-blue-dress/","priyanka-augustin-pink-blue-dress");
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/posters/priya-at-pochampally-ikat-artmela/","priya-at-pochampally-ikat-artmela");
		downloadFiles.put("https://starzone.ragalahari.com/june2017/photosessions/priyanka-augustin-in-half-saree/","priyanka-augustin-in-half-saree");
		downloadFiles.put("https://starzone.ragalahari.com/june2021/photosessions/priyanka-augustin-yellow-divided-skirt-rps/","priyanka-augustin-yellow-divided-skirt-rps");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/starzone/priya-augustin-yellow-dress/","priya-augustin-yellow-dress10");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/proia-augustin-long-frock-hd-photos/","proia-augustin-long-frock-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-red-shirt-denim-shorts-rps/","priyanka-augustin-red-shirt-denim-shorts-rps");
		downloadFiles.put("https://starzone.ragalahari.com/july2019/posters/priya-augustin-mass-power-50days/","priya-augustin-mass-power-50days");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/proia-augustin-long-frock-hd-photos/","proia-augustin-long-frock-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/photosessions/priyanka-augustin-traditional-diya-rps/","priyanka-augustin-traditional-diya-rps");
		downloadFiles.put("https://starzone.ragalahari.com/dec2020/hd/priya-augustin-super-power-trailer/", "priya-augustin-super-power-trailer");
		downloadFiles.put("https://starzone.ragalahari.com/april2019/hd/priya-augustin-runam-pm/", "priya-augustin-runam-pm");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/feb2015/photosessions/manisha-pillai-ragalahari/", "manisha-pillai-ragalahari");
//		downloadFiles.put("https://starzone.ragalahari.com/august2009/starzone/waheeda5/", "waheeda");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-silk-purplish-pink-saree-rps/", "priyanka-augustin-silk-purplish-pink-saree-rps");
		downloadFiles.put("https://starzone.ragalahari.com/feb2017/photosessions/priyanka-augustin-hd-pics-in-blue-dress/", "priyanka-augustin-hd-pics-in-blue-dress");
		downloadFiles.put("https://starzone.ragalahari.com/dec2017/starzone/priyanka-augustin-red-dress/", "priyanka-augustin-red-dress");
		downloadFiles.put("https://starzone.ragalahari.com/june2018/hd/priya-augustin-wallpapers/", "priya-augustin-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/june2018/starzone/priyanka-augustin-saree/", "priyanka-augustin-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2018/starzone/augustin-priya/","augustin-priya");
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/model-priyanka-augustin-hd-photos/","model-priyanka-augustin-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/mar2018/posters/priya-augustin-jawedhabib-salon-launch/","priya-augustin-jawedhabib-salon-launch");
		downloadFiles.put("https://starzone.ragalahari.com/feb2018/posters/priya-augustin-blue-saree/","priya-augustin-blue-saree");
		downloadFiles.put("https://starzone.ragalahari.com/jan2021/photosessions/priyanka-augustin-white-stripes-top-shorts-rps/","priyanka-augustin-white-stripes-top-shorts-rps");		
		downloadFiles.put("https://starzone.ragalahari.com/aug2014/starzone/manisha-kanyarajsons/","manisha-kanyarajsons");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/photosessions/manisha-pillai-ragalahari-photos/","manisha-pillai-ragalahari-photos");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/model-manisha-pillai/","model-manisha-pillai");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/photosessions/manisha-pillai-ragalahari-glam-stills/","manisha-pillai-ragalahari-glam-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/may2015/posters/manisha-pilla-item-song/","manisha-pilla-item-song");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/manisha-pillai/","manisha-pillai");
		downloadFiles.put("https://starzone.ragalahari.com/july2015/hd/manisha-pillai-high-definition/","manisha-pillai-high-definition");		
		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/manisha-pillai-pics/","manisha-pillai-pics");				
		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/manisha-pillai-wallpapers/","manisha-pillai-wallpapers");		
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/starzone/manisha-pillai-club-republic/","manisha-pillai-club-republic");		
		downloadFiles.put("https://starzone.ragalahari.com/sept2015/starzone/manisha-pillai-club-republic-photos/","manisha-pillai-club-republic-photos");		
		downloadFiles.put("https://starzone.ragalahari.com/nov2015/starzone/manisha-pillai/","manisha-pillai");				
		downloadFiles.put("https://starzone.ragalahari.com/dec2015/posters/manisha-pillai-saree-stills/","manisha-pillai-saree-stills");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/starzone/manisha-pillai-traditional-queen/","manisha-pillai-traditional-queen");		
		downloadFiles.put("https://starzone.ragalahari.com/feb2016/starzone/manisha-pillai-kismet-pub/","manisha-pillai-kismet-pub");
		downloadFiles.put("https://starzone.ragalahari.com/feb2016/photosessions/manisha-pillai-pics/","manisha-pillai-pics");		
		downloadFiles.put("https://starzone.ragalahari.com/may2017/posters/manisha-pillai-akriti-exhibition/","manisha-pillai-akriti-exhibition");
		downloadFiles.put("https://starzone.ragalahari.com/july2017/starzone/manisha-pillai/","manisha-pillai");		
		downloadFiles.put("https://starzone.ragalahari.com/aug2020/hd/manisha-pillai-aug2020/","manisha-pillai-aug2020");
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/hd/manisha-pillai-nov1320/","manisha-pillai-nov1320");		
		downloadFiles.put("https://starzone.ragalahari.com/nov2020/hd/manisha-pillai-pink-lehenga/","manisha-pillai-pink-lehenga");		
		downloadFiles.put("https://starzone.ragalahari.com/dec2020/hd/manisha-pillai/","manisha-pillai");		
		downloadFiles.put("https://starzone.ragalahari.com/feb2021/hd/sadhana-pillai-white-dress/","sadhana-pillai-white-dress");		
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/photosessions/manisha-pillai-actress-ragalahari/","manisha-pillai-actress-ragalahari");		
		downloadFiles.put("https://starzone.ragalahari.com/oct2012/hd/kavya-singh-hot-masala/","kavya-singh-hot-masala");		
		downloadFiles.put("https://starzone.ragalahari.com/oct2011/starzone/shravya-reddy-highres-portfolio/","shravya-reddy-highres-portfolio");		
		downloadFiles.put("https://szcdn.ragalahari.com/june2012/starzone/shravya-reddy-highres/","shravya-reddy-highres");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/starzone/shravya-reddy-nri-audio/","shravya-reddy-nri-audio");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/photosessions/shravya-reddy-short-prom-dress/","shravya-reddy-short-prom-dress");		
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/starzone/shravya-reddy-heroine-nri/","shravya-reddy-heroine-nri");		
		downloadFiles.put("https://szcdn1.ragalahari.com/dec2012/photosessions/shravya-reddy-studio-shoot/","shravya-reddy-studio-shoot");		
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/posters/shravya-reddy-red-dress/","shravya-reddy-red-dress");		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/starzone/shravya-reddy-aey-audio-release/","shravya-reddy-aey-audio-release");		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/starzone/shravya-reddy-hotel-golden-park/","shravya-reddy-hotel-golden-park");		
		downloadFiles.put("https://szcdn.ragalahari.com/feb2013/starzone/shravya-reddy-neerus-designer-embroidery/","shravya-reddy-neerus-designer-embroidery");		
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/hd/nri-movie-heroine-shravya-reddy/","nri-movie-heroine-shravya-reddy");		
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/shravya-reddy-nri-platinum-disc/","shravya-reddy-nri-platinum-disc");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/photosessions/shravya-reddy-black-dress/","shravya-reddy-black-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shravya-reddy-mozarella/","shravya-reddy-mozarella");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shraavya-reddy-portfolio-pics/","shraavya-reddy-portfolio-pics");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/starzone/shravya-reddy-sleepwell/","shravya-reddy-sleepwell");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/shravya-sasya-summer-wedding-line-launch/", "shravya-sasya-summer-wedding-line-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/june2013/starzone/shravya-reddy-at-sundown2-aqua/", "shravya-reddy-at-sundown2-aqua");
		downloadFiles.put("https://img.ragalahari.com/june2013/starzone/shravyareddy-hyderabad-fashion-week/", "shravyareddy-hyderabad-fashion-week");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/shravya-reddy-rainbow-shopping/", "shravya-reddy-rainbow-shopping");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2013/posters/heroine-sravya-reddy/", "heroine-sravya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/shravya-reddy-melange-exhibition-2013/", "shravya-reddy-melange-exhibition-2013");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/starzone/eyy-heroine-shravya-reddy/", "eyy-heroine-shravya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/hd/shravyareddy-hiya-varalakshmi-vratam/", "shravyareddy-hiya-varalakshmi-vratam");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2013/starzone/shravya-reddy-radisson-blu/", "shravya-reddy-radisson-blu");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2013/starzone/shravya-reddy-vasanthayanam-pressmeet/", "shravya-reddy-vasanthayanam-pressmeet");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/starzone/shravya-reddy-at-fashion-show-at-spoil/", "shravya-reddy-at-fashion-show-at-spoil");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2014/starzone/hyderabad-heroine-sravya-reddy/", "hyderabad-heroine-sravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/sravya-reddy-hot/", "sravya-reddy-hot");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/starzone/shravyareddy-tasyaah-awareness-fashion-walk/", "shravyareddy-tasyaah-awareness-fashion-walk");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/starzone/sravya-reddy-portfolio/", "sravya-reddy-portfolio");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-veerudokkade-audio/", "shravya-reddy-veerudokkade-audio");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2014/starzone/shravya-reddy-op-everest-in-pictures/", "shravya-reddy-op-everest-in-pictures");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/starzone/shravya-reddy-at-premaloabc-audio/", "shravya-reddy-at-premaloabc-audio");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-kismet-march21-2014/", "shravya-reddy-kismet-march21-2014");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shravya-reddy-vijaya-rana-franchise-launch/", "shravya-reddy-vijaya-rana-franchise-launch");
		downloadFiles.put("https://imgcdn.ragalahari.com/aug2014/starzone/heroine-shravya-reddy/", "heroine-shravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/posters/shraavya-reddy/", "shraavya-reddy");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/starzone/shraavya-reddy-in-white-dress/", "shraavya-reddy-in-white-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/posters/shraavya-reddy-heroine/shraavya-reddy-heroine1t.jpg", "heroine-shravya-reddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/starzone/shravyareddy/", "shravyareddy");
		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/shravya-reddy-hyderabad-actress/", "shravya-reddy-hyderabad-actress");
		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/photosessions/sravya-reddy-hot-stills/", "sravya-reddy-hot-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/photosessions/sravya-reddy-raagalahari/", "sravya-reddy-raagalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/hd/heroine-shravya-hot-pics/", "heroine-shravya-hot-pics");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/shravyareddy-stateart-gallery/", "shravyareddy-stateart-gallery");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/hd/shravya-reddy-high-definition-photos/", "shravya-reddy-high-definition-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2017/posters/shravya-reddy-balakrishnudu-pre-release/", "shravya-reddy-balakrishnudu-pre-release");
		downloadFiles.put("https://szcdn.ragalahari.com/june2017/posters/shravya-reddy-hq-stills-in-red-dress/", "shravya-reddy-hq-stills-in-red-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2017/hd/shravya-reddy-rogue-teaser-launch/", "shravya-reddy-rogue-teaser-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/posters/shravya-reddy-diwali-hq-photos/", "shravya-reddy-diwali-hq-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shraavya-reddy-green-pleated-jumpsuit-rps/", "shraavya-reddy-green-pleated-jumpsuit-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shravya-reddy-mint-green-saree-rps/", "shravya-reddy-mint-green-saree-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/photosessions/shravya-reddy-purple-dress-rps/", "shravya-reddy-purple-dress-rps");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2018/hd/shraavya-reddy-vastaa-genesis-cr/", "shraavya-reddy-vastaa-genesis-cr");
		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/teertha4/", "teertha4");
		downloadFiles.put("https://szcdn.ragalahari.com/august2009/starzone/teertha8/", "teertha8");
		downloadFiles.put("https://starzone.ragalahari.com/dec2017/hd/geet-shah-yellow-saree/", "geet-shah-yellow-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2017/photosessions/monica-thompson-red-long-skirt/", "monica-thompson-red-long-skirt");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/monica-thompson-actress-hot-stills-ragalahari/", "monica-thompson-actress-hot-stills-ragalahari");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/photosessions/tamil-actress-monica-thompson-photos/", "tamil-actress-monica-thompson-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/photosessions/monica-thompson-in-designer-dress/", "monica-thompson-in-designer-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/april2014/photosessions/mithuna-waliya-ragalahari-photos/", "mithuna-waliya-ragalahari-photos");
		downloadFiles.put("https://szcdn1.ragalahari.com/oct2013/photosessions/mithuna-waliya-hot-unseen-photos/", "mithuna-waliya-hot-unseen-photos");		
		downloadFiles.put("https://szcdn.ragalahari.com/sept2013/starzone/mithuna-waliya-lovejunction-platinum/", "mithuna-waliya-lovejunction-platinum");
		downloadFiles.put("https://szcdn.ragalahari.com/april2016/starzone/midhuna-in-saree-stills/", "midhuna-in-saree-stills");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/photosessions/vennilavin-arangetram-mithuna-waliya/", "vennilavin-arangetram-mithuna-waliya");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2015/hd/monica-thompson-hot-pics/", "monica-thompson-hot-pics");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/pooja-sree-glam-photos/", "pooja-sree-glam-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/may2022/hd/eesha-rebba-shekar-trailer-launch/", "eesha-rebba-shekar-trailer-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/april2017/photosessions/sindhura-rout-in-mini-frock-hd-stills/", "sindhura-rout-in-mini-frock-hd-stills");
		downloadFiles.put("https://img.ragalahari.com/gallery/sundhutolani3/", "sundhutolani3");
		downloadFiles.put("https://img.ragalahari.com/gallery/sindhutolani4/", "sindhutolani4");
		downloadFiles.put("https://img.ragalahari.com/gallery/sindhutolani4/", "sindhutolani4");
		downloadFiles.put("https://starzone.ragalahari.com/june2008gallery/sindhutolani7/", "sindhutolani7");
		downloadFiles.put("https://starzone.ragalahari.com/march2008gallery/sindhutolani6/", "sindhutolani6");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-minibalcktop-ragalahari-ps/", "deepika3-minibalcktop-ragalahari-ps");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-silver-dress-set2-ragalahari-ps/", "deepika3-silver-dress-set2-ragalahari-ps");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2012/starzone/deepika3-white-top-ragalahari-ps/", "deepika3-white-top-ragalahari-ps");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-black-white-ragalahari-ps/", "deepika3-black-white-ragalahari-ps");
		downloadFiles.put("https://img.ragalahari.com/jan2012/starzone/deepika3-pink-saree-ragalahari-ps/", "deepika3-pink-saree-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/starzone/vinisha-naidu-movie-shoot/", "vinisha-naidu-movie-shoot");
		downloadFiles.put("https://szcdn1.ragalahari.com/april2012/starzone/hema-ragalahari-photo-session/", "hema-ragalahari-photo-session");
		downloadFiles.put("https://szcdn.ragalahari.com/september2009/starzone/devi/","devi");
		downloadFiles.put("http://szcdn1.ragalahari.com/feb2012/starzone/payal-gosh-blue-skirt-ragalahari-photo-session/", "payal-gosh-blue-skirt-ragalahari-photo-session");
		downloadFiles.put("https://starzone.ragalahari.com/june2011/starzone/nisha-gray-ragalahari-ps/", "nisha-gray-ragalahari-ps");

		downloadFiles.put("https://szcdn.ragalahari.com/mar2017/posters/ashwini-nuv-nenu-osey-orey-pm/", "ashwini-nuv-nenu-osey-orey-pm");
	downloadFiles.put("https://szcdn.ragalahari.com/jan2020/photosessions/gunjan-aras-mixed-jan2220-rps/", "gunjan-aras-mixed-jan2220-rps");
		
		downloadFiles.put("https://imgcdn.ragalahari.com/april2015/photosessions/vidya-vinod-indarkar/", "vidya-vinod-indarkar");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-vinod-indurkar-ragalahari-photoshoot/", "vidya-vinod-indurkar-ragalahari-photoshoot");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-indurkar-glam-stills/", "vidya-indurkar-glam-stills");
		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-vinod-indurkar-high-definition-photos/", "vidya-vinod-indurkar-high-definition-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/model-vidya-indurkar-blue-saree-photos/", "model-vidya-indurkar-blue-saree-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/vidya-indurkar-half-saree-stills/", "vidya-indurkar-half-saree-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/july2015/posters/vidya-vinod-indarkar-photo-gallery/", "vidya-vinod-indarkar-photo-gallery");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2014/starzone/vidya-sareedraping-workshop-by-dollyjain/", "vidya-sareedraping-workshop-by-dollyjain");
		
		downloadFiles.put("https://szcdn1.ragalahari.com/mar2012/starzone/bindu-spicy-hires/", "bindu-spicy-hires");
		downloadFiles.put("https://szcdn.ragalahari.com/july2012/starzone/tamakshi-ayomayam-apartment/", "tamakshi-ayomayam-apartment");
		downloadFiles.put("https://imgcdn.ragalahari.com/oct2014/photosessions/smitha-tiwari-photoshoot/", "smitha-tiwari-photoshoot");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2011/starzone/sannemadsen-spicy-photosession/", "sannemadsen-spicy-photosession");
		downloadFiles.put("https://szcdn.ragalahari.com/july2014/photosessions/indian-actress-tanusha/", "indian-actress-tanusha");		
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/photosessions/heroine-tanusha-glam-pics/", "heroine-tanusha-glam-pics");

*/		
//		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tanusha-swathi-in-pink-dress/", "tanusha-swathi-in-pink-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/august2009/starzone/waheeda5/", "waheeda52");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/vasavireddy/", "vasavireddy");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2022/photosessions/selina-green-sequin-bodycon-rps/", "selina-green-sequin-bodycon-rps");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2022/photosessions/ankita-bhattacharya-photoshoot-jan2022/", "ankita-bhattacharya-photoshoot-jan2022");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2022/photosessions/prantika-das-brown-floral-mini-dress-rps/", "prantika-das-brown-floral-mini-dress-rps");
//		downloadFiles.put("https://img.ragalahari.com/jan2011/starzone/bhanu-sri-mehra-high-resolution-gallery/", "bhanu-sri-mehra-high-resolution-gallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/aashiroy-npfashions/", "aashiroy-npfashions");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2019/posters/ashi-roy-ks100-poster-launch/", "ashi-roy-ks100-poster-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2019/posters/ashi-roy-ks100-interview1/", "ashi-roy-ks100-interview");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2010/starzone/Aishwarya-Buridi-Heroine/", "Aishwarya-Buridi-Heroine");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2013/starzone/alekhya-gulabi-audio-release/", "alekhya-gulabi-audio-release");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/hd/amrutha-valli-hot-beach-shots/", "amrutha-valli-hot-beach-shots");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2020/hd/anveshijain-commitment-teaser-launch/", "anveshijain-commitment-teaser-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2020/hd/anveshi-jain-commitment-title-launch/", "anveshi-jain-commitment-title-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/hd/archana-high-definition/", "archana-high-definition");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/starzone/heroine-bhavisyika/", "heroine-bhavisyika");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2022/hd/dimple-hayathi-khiladi-press-meet/", "dimple-hayathi-khiladi-press-meet");
//		downloadFiles.put("https://szcdn.ragalahari.com/sep2019/hd/dimple-hayati-valmiki-pre-release/", "dimple-hayati-valmiki-pre-release");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2011/starzone/nisha-reddress-photogallery/", "nisha-reddress-photogallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2016/photosessions/shalini-hd-photoshoot-stills/", "shalini-hd-photoshoot-stills");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/sept2010/starzone/chapter-6-heroine-sonia-suri-photo-gallery/", "chapter-6-heroine-sonia-suri-photo-gallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2010/starzone/sunkashi-gallery4/", "sunkashi-gallery4");
//		downloadFiles.put("https://szcdn.ragalahari.com/sept2014/starzone/vida-hot-pics/" , "vida-hot-pics");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2009/starzone/vainavi1/", " vainavi");
		
//		downloadFiles.put("https://starzone.ragalahari.com/may2009/starzone/vainavi1/", "vainavi1");
//		downloadFiles.put("https://starzone.ragalahari.com/june2008gallery/tanya1/", "tanya");
//		downloadFiles.put("https://starzone.ragalahari.com/june2008gallery/tanya1/", "tanya1");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/rekhasri1/", "rekhasri1");
//		downloadFiles.put("https://szcdn.ragalahari.com/december2008gallery/ruthika7/", "ruthika7");
//		downloadFiles.put("https://starzone.ragalahari.com/september2009/starzone/ruthika9/", "ruthika9");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2018/photosessions/actress-ruchira-in-black-dress/", "actress-ruchira-in-black-dress");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2016/starzone/pragya-vangaveeti-event/", "pragya-vangaveeti-event");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2016/hd/pooja-misra-hot-photoshoot/", "pooja-misra-hot-photoshoot");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2022/hd/nitya-naresh-luzo-box-launch/", "nitya-naresh-luzo-box-launch");
//		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/posters/nitya-naresh-naveen-vijayakrishna-film-muhurat/", "nitya-naresh-naveen-vijayakrishna-film-muhurat");
//		downloadFiles.put("https://szcdn1.ragalahari.com/mar2013/posters/sunaina-in-samar/", "sunaina-in-samar");
//		downloadFiles.put("https://starzone.ragalahari.com/july2009/starzone/srilekhatwo1/", "srilekhatwo");
//		downloadFiles.put("https://img.ragalahari.com/dec2009/starzone/sonusharma2/", "sonusharma2");
//		downloadFiles.put("https://szcdn1.ragalahari.com/dec2012/photosessions/sri-chandana-spicy-photos/", "sri-chandana-spicy-photos");
//		downloadFiles.put("https://szcdn1.ragalahari.com/aug2012/photosessions/srichandana-black-gown-spicy-photos/", "srichandana-black-gown-spicy-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2009/starzone/arthipuri9/", "arthipuri9");
//		downloadFiles.put("https://img.ragalahari.com/feb2010/starzone/arthipuri12/", "arthipuri12");
//		downloadFiles.put("https://szcdn.ragalahari.com/september2009/starzone/arthipuri7/", "arthipuri7");
//		downloadFiles.put("https://starzone.ragalahari.com/june2009/starzone/arthipuri5/", "arthipuri5");
//		downloadFiles.put("https://starzone.ragalahari.com/may2009/starzone/arthipuri4/", "arthipuri4");
//		downloadFiles.put("https://starzone.ragalahari.com/may2011/starzone/arthi-puri-high-resolution/", "arthi-puri-high-resolution");
//		downloadFiles.put("https://starzone.ragalahari.com/may2011/starzone/arthi-puri-high-resolution-sanghatana-muhurat/", "arthi-puri-high-resolution-sanghatana-muhurat");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2009/starzone/arthipuri11/", "arthipuri11");
//		downloadFiles.put("https://starzone.ragalahari.com/may2014/hd/heroine-chaarulatha-hot-pics/", "heroine-chaarulatha-hot-pics");
//		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/heroine-chaarulatha/", "heroine-chaarulatha");
//		downloadFiles.put("https://starzone.ragalahari.com/june2016/photosessions/indian-filmactress-shunaya-solanki/", "indian-filmactress-shunaya-solanki");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2020/photosessions/shunaya-solanki-yellow-croptop-slit-skirt-rps/", "shunaya-solanki-yellow-croptop-slit-skirt-rps");
//		downloadFiles.put("https://img.ragalahari.com/feb2010/starzone/shehatwo1/", "shehatwo1");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2010/starzone/sneha-spicy-gallery/", "sneha-spicy-gallery");
//		downloadFiles.put("https://img.ragalahari.com/gallery/ramya5/", "ramya5");
//		downloadFiles.put("https://starzone.ragalahari.com/december2008gallery/ramya(3)8/", "ramya(3)8");
//		downloadFiles.put("https://starzone.ragalahari.com/january2009gallery/starzone/ramyathree8/", "ramyathree8");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/hd/ashi-roy-indian-silk-expo/", "ashi-roy-indian-silk-expo");
//		downloadFiles.put("https://starzone.ragalahari.com/june2010/starzone/Spoorthi-Das6/", "Spoorthi-Das6");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2010/starzone/spoorthi-das-saree-session/", "spoorthi-das-saree-session");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2011/starzone/spoorthi-ragalahari-photo-session/", "spoorthi-ragalahari-photo-session");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2010/starzone/spoorthi-das-spicy-session/", "spoorthi-das-spicy-session");
//		downloadFiles.put("https://starzone.ragalahari.com/april2010/starzone/spoorthidas4/", "spoorthidas4");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2010/starzone/spoorthi-das-photo-session8/", "spoorthi-das-photo-session8");
//		downloadFiles.put("https://starzone.ragalahari.com/august2009/starzone/taslimasheik2/", "taslimasheik2");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2018/photosessions/sanjananaidu-spicy-photoshoot/", "sanjananaidu-spicy-photoshoot");
//		downloadFiles.put("https://imgcdn.ragalahari.com/may2015/posters/saritha-cuba-libre-may29-2015/", "saritha-cuba-libre-may29-2015");
//		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/telangana-model-saritha/", "telangana-model-saritha");
//		downloadFiles.put("https://imgcdn.ragalahari.com/july2015/hd/gehana-high-definition/", "gehana-high-definition");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/photosessions/vandana-vasisth-spicy-pics/", "vandana-vasisth-spicy-pics");
//		downloadFiles.put("https://szcdn1.ragalahari.com/feb2013/photosessions/vandana-vasisth-ragalahari-shoot/", "vandana-vasisth-ragalahari-shoot");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2015/photosessions/gehana_vasisth_ragalahari_pics/", "gehana_vasisth_ragalahari_pics");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/photosessions/gehana-vasisth-photoshoot-red-dress/", "gehana-vasisth-photoshoot-red-dress");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/photosessions/gehana-vasisth-photoshoot-red-dress/", "gehana-vasisth-photoshoot-red-dress");
//		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/photosessions/shalini/", "shalini");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2013/photosessions/seethal-sidge-ragalahari-hot-photos/", "seethal-sidge-ragalahari-hot-photos");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2013/photosessions/seethal-sidge-hot-spicy-pics/", "seethal-sidge-hot-spicy-pics");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2015/photosessions/seethal-sidge-2015-photos/", "seethal-sidge-2015-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2014/photosessions/seethal-sidge-glam-shoot/", "seethal-sidge-glam-shoot");
//		downloadFiles.put("https://starzone.ragalahari.com/may2014/photosessions/seethal-sidge-ragalahari-photos/", "seethal-sidge-ragalahari-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/april2013/starzone/seethal-sidge-spicy-stills/", "seethal-sidge-spicy-stills");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2013/hd/ritukaur-gurudu-red-skirt/", "ritukaur-gurudu-red-skirt");
//		downloadFiles.put("https://szcdn1.ragalahari.com/jan2013/posters/ritu-kaur-hot-spicy-pics/", "ritu-kaur-hot-spicy-pics");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2013/posters/heroine-gurudu-ritu/", "heroine-gurudu-ritu");
//		downloadFiles.put("https://imgcdn.ragalahari.com/dec2013/posters/ritukaur-dancing-in-red-saree/", "ritukaur-dancing-in-red-saree");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2013/hd/ritu-kaur-hot-stills/", "ritu-kaur-hot-stills");
//		downloadFiles.put("https://szcdn1.ragalahari.com/jan2013/hd/gurudu-heroine-ritu-kaur-hd/", "gurudu-heroine-ritu-kaur-hd");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/posters/ritu-kaur-in-saree/", "ritu-kaur-in-saree");
//		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/vidarsha-manushalato-jagratha-audio/", "vidarsha-manushalato-jagratha-audio");
//		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/vidarsha-manushalato-jagratha-audio-sm/", "vidarsha-manushalato-jagratha-audio-sm");
//		downloadFiles.put("https://starzone.ragalahari.com/july2013/starzone/vidharsha-manushalato-jagratha-pm/", "vidharsha-manushalato-jagratha-pm");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2012/posters/sumitha-spicy-posters/", "sumitha-spicy-posters");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2012/hd/kavya-singh-hot-saree/", "kavya-singh-hot-saree");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2012/hd/kavya-singh-spicy/", "kavya-singh-spicy");
//		downloadFiles.put("https://starzone.ragalahari.com/april2013/starzone/kavya-singh-half-boil-audio/", "kavya-singh-half-boil-audio");
//		downloadFiles.put("https://szcdn1.ragalahari.com/april2013/hd/anusmriti-sarkar-hot/", "anusmriti-sarkar-hot");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2014/photosessions/anu-smriti-sarkar-in-pink-dress/", "anu-smriti-sarkar-in-pink-dress");
//		downloadFiles.put("https://media.ragalahari.com/march2009/starzone/sidhie4/", "sidhie4");
//		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/sidhie9/", "sidhie9");
//		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/roopakaur8/", "roopakaur8");
//		downloadFiles.put("https://starzone.ragalahari.com/december2008gallery/roopakaur6/", "roopakaur6");
//		downloadFiles.put("https://starzone.ragalahari.com/january2009gallery/starzone/roopakaur7/", "roopakaur7");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2016/photosessions/telugu-actress-chaitanya-photos/", "telugu-actress-chaitanya-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2022/hd/tejaswi-madiwada-commitment-interview/", "tejaswi-madiwada-commitment-interview");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2016/photosessions/actress-chaitanya-saree-stills/", "actress-chaitanya-saree-stills");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2016/photosessions/chaitanya-telugu-actress-photos/", "chaitanya-telugu-actress-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2022/hd/chaithanya-priya-purna-movie-launch/", "chaithanya-priya-purna-movie-launch");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2018/hd/charishma-shreekar-trendz-exhibition/", "charishma-shreekar-trendz-exhibition");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2018/starzone/charishma-shreekar-neethonehaihai/", "charishma-shreekar-neethonehaihai");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2018/hd/charishma-shreekar-akrittielite-launch/", "charishma-shreekar-akrittielite-launch");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2022/photosessions/pranjal-palkar-white-floral-dress-rps/", "pranjal-palkar-white-floral-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2021/photosessions/pranjal-palkar-light-pink-dress-rps/", "pranjal-palkar-light-pink-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2022/photosessions/aparna-mallik-orange-half-saree-rps/", "aparna-mallik-orange-half-saree-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2021/photosessions/aparnna-orange-half-placket-crop-top-rps/", "aparnna-orange-half-placket-crop-top-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2012/posters/aasheeka-bathija-long-skirt-posters/", "aasheeka-bathija-long-skirt-posters");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2011/starzone/aashika-at-santhoshampm-highresolution/", "aashika-at-santhoshampm-highresolution");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/photosessions/siya-gautham-pink-floral-mini-dress-rps/", "siya-gautham-pink-floral-mini-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/photosessions/siya-gautham-pink-floral-mini-dress-rps/", "siya-gautham-pink-floral-mini-dress-rps");
//		downloadFiles.put("https://starzone.ragalahari.com/may2009/starzone/arora1/", "arora1");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2022/hd/dimple-hayati-photoshoot-aug2022/", "dimple-hayati-photoshoot-aug2022");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2014/photosessions/zeba-khan-ragalahari-photos/", "zeba-khan-ragalahari-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2016/photosessions/shalini-glam-stills-in-shorts/", "shalini-glam-stills-in-shorts");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2014/photosessions/shalini/", "shalini");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2012/photosessions/anjali-dwivedi-exclusive-studio-shoot/", "anjali-dwivedi-exclusive-studio-shoot");
//		downloadFiles.put("https://szcdn1.ragalahari.com/mar2012/starzone/anjali-dwivedi-ragalahari-session/", "anjali-dwivedi-ragalahari-session");
//		downloadFiles.put("https://szcdn1.ragalahari.com/oct2012/photosessions/anjali-dwivedi-hot-sleeveless-dress/", "anjali-dwivedi-hot-sleeveless-dress");
//		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/hd/menaka-hot-photoshoot-hd/", "menaka-hot-photoshoot-hd");
//		downloadFiles.put("https://szcdn1.ragalahari.com/mar2013/posters/menaka-spicy-saree/", "menaka-spicy-saree");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2011/starzone/ayesha-blackdress-photosession/", "ayesha-blackdress-photosession");
//		downloadFiles.put("https://starzone.ragalahari.com/april2011/starzone/ayesha2-blackdress-ragalahari-photosession/", "ayesha2-blackdress-ragalahari-photosession");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2011/starzone/ayesha2-orange-dress-ragalahari-ps/", "ayesha2-orange-dress-ragalahari-ps");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2011/starzone/ayesha2-black-shirt-ragalahari-ps/", "ayesha2-black-shirt-ragalahari-ps");
//		downloadFiles.put("https://starzone.ragalahari.com/april2016/photosessions/priya-singh-ragalahari-photoshoot/", "priya-singh-ragalahari-photoshoot");
//		downloadFiles.put("https://starzone.ragalahari.com/december2008gallery/ramya(3)8/", "ramya(3)8");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2015/posters/ramya-loafer-success-meet/", "ramya-loafer-success-meet");
//		downloadFiles.put("https://starzone.ragalahari.com/april2017/hd/shunaya-solanki-hot-stills/", "shunaya-solanki-hot-stills");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2017/photosessions/sindhura-rout-heroine/", "sindhura-rout-heroine");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2016/photosessions/sindhura-rout-ragalahari/", "sindhura-rout-ragalahari");
/*
		downloadFiles.put("https://starzone.ragalahari.com/oct2016/photosessions/model-sindura-rout-hd-wallpapers/", "model-sindura-rout-hd-wallpapers");
		downloadFiles.put("https://starzone.ragalahari.com/mar2017/photosessions/sindhura-rout-hd-glam-photos/", "sindhura-rout-hd-glam-photos");
		downloadFiles.put("https://starzone.ragalahari.com/june2020/hd/sindura-rout-june2020/", "sindura-rout-june2020");
		downloadFiles.put("https://starzone.ragalahari.com/mar2020/hd/sindhura-rout-naakide-first-time-audio/", "sindhura-rout-naakide-first-time-audio");
		downloadFiles.put("https://starzone.ragalahari.com/april2017/photosessions/sindhura-rout-in-pink-dress-hd-photos/", "sindhura-rout-in-pink-dress-hd-photos");
*/		
/*
		downloadFiles.put("https://starzone.ragalahari.com/aug2021/hd/gehna-vasishta-photoshoot-aug2021/", "gehna-vasishta-photoshoot-aug2021");
		downloadFiles.put("https://starzone.ragalahari.com/oct2020/hd/gehana-vasisth-oct2020/", "gehana-vasisth-oct2020");
		downloadFiles.put("https://starzone.ragalahari.com/sep2020/starzone/gehana-vasisth-red-bikini-sep2020/", "gehana-vasisth-red-bikini-sep2020");
		downloadFiles.put("https://starzone.ragalahari.com/may2020/hd/gehana-vasisth-fabglam-studios-may2020/", "gehana-vasisth-fabglam-studios-may2020");
		downloadFiles.put("https://starzone.ragalahari.com/may2020/starzone/gehana-vasisth-may2020/", "gehana-vasisth-may2020");
		downloadFiles.put("https://starzone.ragalahari.com/dec2019/hd/gehana-vasisth-arabic-song/", "gehana-vasisth-arabic-song");
		downloadFiles.put("https://starzone.ragalahari.com/nov2019/hd/gehna-vasishta-photoshoot-nov2719/", "gehna-vasishta-photoshoot-nov2719");
		downloadFiles.put("https://starzone.ragalahari.com/april2018/hd/gehana-vasisth-red/", "gehana-vasisth-red");
		downloadFiles.put("https://starzone.ragalahari.com/mar2018/starzone/gehana-vasist-private-pictures/", "gehana-vasist-private-pictures");
		downloadFiles.put("https://starzone.ragalahari.com/mar2018/hd/gehana-vasisth-stills/", "gehana-vasisth-stills");
		downloadFiles.put("https://starzone.ragalahari.com/aug2017/starzone/gehana-vasisth-bollywood/", "gehana-vasisth-bollywood");
		downloadFiles.put("https://starzone.ragalahari.com/may2017/hd/gehana-vasisth-latest-portfolio/", "gehana-vasisth-latest-portfolio201");
		downloadFiles.put("https://starzone.ragalahari.com/jan2017/starzone/gehana-vasisth-innerwear/", "gehana-vasisth-innerwear");
		downloadFiles.put("https://starzone.ragalahari.com/oct2016/starzone/gehana-vasisth-latest-photos/", "gehana-vasisth-latest-photos");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2016/starzone/gehana/", "gehana");
		downloadFiles.put("https://starzone.ragalahari.com/july2016/posters/gehna-vasisth-poolside-pics/", "gehna-vasisth-poolside-pics");
		downloadFiles.put("https://starzone.ragalahari.com/june2016/starzone/gehana-vasisth-in-chudidar/", "gehana-vasisth-in-chudidar");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/bollywood-gehana-vasisth-glam-stills/", "bollywood-gehana-vasisth-glam-stills");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/starzone/gehana-vasisth-golden-dress/", "gehana-vasisth-golden-dress");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/gehana-vasisth-in-blue-saree-hd/", "gehana-vasisth-in-blue-saree-hd");
		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/gehana-vasisth-red-hd-stills/", "gehana-vasisth-red-hd-stills");
		downloadFiles.put("https://starzone.ragalahari.com/aug2015/photosessions/gehana_vasisth_ragalahari_pics/", "gehana_vasisth_ragalahari_pics");
		downloadFiles.put("https://starzone.ragalahari.com/oct2015/starzone/gehana/", "gehana");
		downloadFiles.put("https://starzone.ragalahari.com/july2015/photosessions/gehana-vasisth-hottest-photoshoot/", "gehana-vasisth-hottest-photoshoot");
		downloadFiles.put("https://starzone.ragalahari.com/july2015/photosessions/savita-barbie-actress-gehana-vasisth-photos/", "savita-barbie-actress-gehana-vasisth-photos");
		downloadFiles.put("https://starzone.ragalahari.com/aug2015/starzone/gehna-vashisht-glam-stills/", "gehna-vashisht-glam-stills");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/photosessions/gehana-vasisth-photoshoot-red-dress/", "gehana-vasisth-photoshoot-red-dress");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/gehana-photos/", "gehana-photos");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/hd/gehana-vasisth-high-definition/", "gehana-vasisth-high-definition");
		downloadFiles.put("https://starzone.ragalahari.com/april2015/starzone/gehana/", "gehana");
		downloadFiles.put("https://imgcdn.ragalahari.com/may2015/photosessions/kollywood-actress-gehana-vasisth-ragalahari/", "kollywood-actress-gehana-vasisth-ragalahari");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/gehana-pics/", "gehana-pics");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/gehana/", "gehana");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/gehna-vasisth-bluemoon/", "gehna-vasisth-bluemoon");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/gehana-vasisth/", "gehana-vasisth");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/gehana-vasisth-lucknowi-ishq/", "gehana-vasisth-lucknowi-ishq");
//		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/hd/gehana/", "gehana");
		downloadFiles.put("https://imgcdn.ragalahari.com/sept2014/hd/gehana-vasisth-hd-photos/", "gehana-vasisth-hd-photos");
		downloadFiles.put("https://starzone.ragalahari.com/oct2014/photosessions/chhattisgarh-actress-gehana-vasisth/", "chhattisgarh-actress-gehana-vasisth");
		downloadFiles.put("https://starzone.ragalahari.com/oct2014/starzone/gehana-vaisth-in-saree/", "gehana-vaisth-in-saree");
		downloadFiles.put("https://starzone.ragalahari.com/aug2014/hd/gehana-vasisth-in-pink-dress/", "gehana-vasisth-in-pink-dress");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/starzone/gehana-vasisth-shoot/", "gehana-vasisth-shoot");
		downloadFiles.put("https://starzone.ragalahari.com/jan2014/photosessions/bollywood-actress-gehana-vasisth/", "bollywood-actress-gehana-vasisth");
		downloadFiles.put("https://starzone.ragalahari.com/jan2014/starzone/gehna-vashisht-fncc-2014-celebrations/", "gehna-vashisht-fncc-2014-celebrations");
		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/photosessions/gehna-vashisht-twitter-hot-photos/", "gehna-vashisht-twitter-hot-photos");
		
		downloadFiles.put("https://starzone.ragalahari.com/aug2013/starzone/heroine-gehna/", "heroine-gehna");
		downloadFiles.put("https://szcdn1.ragalahari.com/may2013/photosessions/vandana-vasisth-spicy-pics/", "vandana-vasisth-spicy-pics");
		downloadFiles.put("https://starzone.ragalahari.com/july2013/starzone/gehna-vashisht-hot-pics/", "gehna-vashisht-hot-pics");
		downloadFiles.put("https://starzone.ragalahari.com/july2013/starzone/vandanavasisth-parinaya-wedding-fair/", "vandanavasisth-parinaya-wedding-fair");
		downloadFiles.put("https://starzone.ragalahari.com/june2013/starzone/vandana-vasisth-black-dress/", "vandana-vasisth-black-dress");
		downloadFiles.put("https://starzone.ragalahari.com/april2013/starzone/vandana-vasisth-hyderabad-sunrisers/", "vandana-vasisth-hyderabad-sunrisers");
		downloadFiles.put("https://szcdn1.ragalahari.com/feb2013/photosessions/vandana-vasisth-ragalahari-shoot/", "vandana-vasisth-ragalahari-shoot");
		
		downloadFiles.put("https://starzone.ragalahari.com/june2014/starzone/vandana-vashisht-33premakathalu-audio/", "vandana-vashisht-33premakathalu-audio");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2016/starzone/gehana/", "gehana");
		downloadFiles.put("https://szcdn1.ragalahari.com/feb2013/photosessions/vandana-vasisth-ragalahari-shoot/", "vandana-vasisth-ragalahari-shoot");
		downloadFiles.put("https://starzone.ragalahari.com/jan2013/starzone/vandana-vasisth-symphony-music-academy/", "vandana-vasisth-symphony-music-academy");
*/		
//		downloadFiles.put("https://starzone.ragalahari.com/dec2019/hd/sneha-gupta-raghava-reddy-song/","sneha-gupta-raghava-reddy-song");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2019/posters/asi-roy-ks-100-audio-launch/","asi-roy-ks-100-audio-launch");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2019/posters/ashi-roy-ks100-teaser-launch/","ashi-roy-ks100-teaser-launch");
/*
		downloadFiles.put("https://starzone.ragalahari.com/mar2019/posters/nikki-tamboli-cgc-prerelease/","nikki-tamboli-cgc-prerelease");
		downloadFiles.put("https://starzone.ragalahari.com/nov2019/hd/nikki-thamboli-thippara-meesam-pre/","nikki-thamboli-thippara-meesam-pre");
		downloadFiles.put("https://starzone.ragalahari.com/oct2019/hd/nikki-tamboli-thippara-meesam-pm/","nikki-tamboli-thippara-meesam-pm");
		downloadFiles.put("https://starzone.ragalahari.com/may2019/hd/nikki-tamboli-sutraa-exhibition/","nikki-tamboli-sutraa-exhibition");
		downloadFiles.put("https://starzone.ragalahari.com/april2019/starzone/nikkitamboli-kanchana-3-successmeet/","nikkitamboli-kanchana-3-successmeet");
		downloadFiles.put("https://starzone.ragalahari.com/april2019/posters/nikki-tamboli-kanchana3-prerelease/","nikki-tamboli-kanchana3-prerelease");
		downloadFiles.put("https://starzone.ragalahari.com/mar2019/posters/nikki-tamboli-cgck-success/","nikki-tamboli-cgck-success");
		downloadFiles.put("https://starzone.ragalahari.com/mar2019/posters/nikki-tamboli-cgc-prerelease/","nikki-tamboli-cgc-prerelease");
		downloadFiles.put("https://starzone.ragalahari.com/jan2019/hd/nikki-tamboli-cgck-trailer-launch/","nikki-tamboli-cgck-trailer-launch");
*/
/*		
		downloadFiles.put("https://starzone.ragalahari.com/nov2018/posters/sanjananaidu-spicy-photo-gallery/","sanjananaidu-spicy-photo-gallery");
		downloadFiles.put("https://starzone.ragalahari.com/oct2018/starzone/sanjananaidu-photo-gallery/","sanjananaidu-photo-gallery");
		downloadFiles.put("https://starzone.ragalahari.com/july2018/hd/sanjana-naidu-red-hot/","sanjana-naidu-red-hot");
		downloadFiles.put("https://starzone.ragalahari.com/oct2018/photosessions/sanjananaidu-spicy-photoshoot/","sanjananaidu-spicy-photoshoot");
		downloadFiles.put("https://starzone.ragalahari.com/nov2018/photosessions/sanjana-naidu-gold-dress-ps/","sanjana-naidu-gold-dress-ps");
		downloadFiles.put("https://starzone.ragalahari.com/nov2018/posters/sanjananaidu-spicy-photo-gallery/","sanjananaidu-spicy-photo-gallery");
		downloadFiles.put("https://starzone.ragalahari.com/july2021/photosessions/sanjana-naidu-blue-sequin-one-shoulder-rps/","sanjana-naidu-blue-sequin-one-shoulder-rps");
		downloadFiles.put("https://starzone.ragalahari.com/july2021/photosessions/sanjana-naidu-blue-floral-dress-rps/","sanjana-naidu-blue-floral-dress-rps");
		downloadFiles.put("https://starzone.ragalahari.com/july2021/photosessions/sanjana-naidu-royal-blue-ruffle-dress-rps/","sanjana-naidu-royal-blue-ruffle-dress-rps");
		downloadFiles.put("https://starzone.ragalahari.com/feb2022/hd/sanjana-naidu-pink-frill-dress/","sanjana-naidu-pink-frill-dress");
		downloadFiles.put("https://starzone.ragalahari.com/mar2022/hd/sanjana-naidu-white-sequin-dress/","sanjana-naidu-white-sequin-dress");
*/		
/*		
		downloadFiles.put("https://starzone.ragalahari.com/june2016/starzone/pooja-shree-khan-saab-restaurant/","pooja-shree-khan-saab-restaurant");
		downloadFiles.put("https://starzone.ragalahari.com/feb2018/hd/pooja-singh-dandupalyam/","pooja-singh-dandupalyam"); //1
		downloadFiles.put("https://starzone.ragalahari.com/nov2017/photosessions/poojaa-sree-half-saree/","poojaa-sree-half-saree"); //2
		downloadFiles.put("https://starzone.ragalahari.com/oct2017/photosessions/pooja-sree-glam-hd-stills/","pooja-sree-glam-hd-stills"); //3
		downloadFiles.put("https://starzone.ragalahari.com/oct2017/photosessions/hindi-actress-pooja-sree/","hindi-actress-pooja-sree"); //4
		downloadFiles.put("https://starzone.ragalahari.com/sep2017/photosessions/actress-pooja-sree-hot-stills/", "actress-pooja-sree-hot-stills"); //6
		downloadFiles.put("https://starzone.ragalahari.com/sep2017/posters/pooja-sree-sarva-fashion-show/", "pooja-sree-sarva-fashion-show");//5
		downloadFiles.put("https://starzone.ragalahari.com/sep2017/photosessions/actress-pooja-sree-cute-expressions/", "actress-pooja-sree-cute-expressions"); //7
		downloadFiles.put("https://starzone.ragalahari.com/aug2017/starzone/pooja-sree-pink-lehanga/", "pooja-sree-pink-lehanga"); //8
		downloadFiles.put("https://szcdn.ragalahari.com/july2017/starzone/pooja-sree-salwar-kameez/", "pooja-sree-salwar-kameez"); //9
		downloadFiles.put("https://szcdn.ragalahari.com/july2017/posters/pooja-sree-national-silk-expo/", "pooja-sree-national-silk-expo"); //10
		downloadFiles.put("https://szcdn.ragalahari.com/june2017/posters/pooja-sree-pochampally-ikat/", "pooja-sree-pochampally-ikat"); //11
		downloadFiles.put("https://szcdn.ragalahari.com/may2017/starzone/pooja-sree-photos/", "pooja-sree-photos"); //12
		downloadFiles.put("https://szcdn.ragalahari.com/may2017/hd/pooja-sree-thickshake-factory-launch/", "pooja-sree-thickshake-factory-launch"); //13
		downloadFiles.put("https://szcdn.ragalahari.com/mar2017/posters/pooja-sree-iifa-utsavam-2017-2day/", "pooja-sree-iifa-utsavam-2017-2day"); //14
		downloadFiles.put("https://szcdn.ragalahari.com/mar2017/posters/pooja-sri-iifa-utsavam/", "pooja-sri-iifa-utsavam"); //15
		downloadFiles.put("https://szcdn.ragalahari.com/dec2016/photosessions/pooja-sree-hd-photoshoot-stills/", "pooja-sree-hd-photoshoot-stills"); //16
		downloadFiles.put("https://szcdn.ragalahari.com/dec2016/photosessions/pooja-sree-hd-glam-stills/", "pooja-sree-hd-glam-stills"); //17
		downloadFiles.put("https://szcdn.ragalahari.com/dec2016/posters/pooja-sree-in-white-mini-dress/", "pooja-sree-in-white-mini-dress"); //18
		downloadFiles.put("https://szcdn.ragalahari.com/dec2016/photosessions/hyderabad-heroine-poojasree/", "hyderabad-heroine-poojasree"); //19
		downloadFiles.put("https://szcdn.ragalahari.com/nov2016/photosessions/pooja-sree-hot-hd-photos-in-gagra/", "pooja-sree-hot-hd-photos-in-gagra"); //20
		downloadFiles.put("https://szcdn.ragalahari.com/nov2016/posters/pooja-sree-vivo-global-phone-launch/", "pooja-sree-vivo-global-phone-launch"); //21
		downloadFiles.put("https://szcdn.ragalahari.com/nov2016/photosessions/pooja-sree-in-white-gown-hd-stills/", "pooja-sree-in-white-gown-hd-stills"); //22
		downloadFiles.put("https://szcdn.ragalahari.com/nov2016/starzone/pooja-sree-adira/", "pooja-sree-adira"); //23
		downloadFiles.put("https://szcdn.ragalahari.com/nov2016/photosessions/pooja-sree-hd-stills-in-langa-voni/", "pooja-sree-hd-stills-in-langa-voni"); //24
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/photosessions/heroine-pooja-sree-wallpapers/", "heroine-pooja-sree-wallpapers"); //25
		downloadFiles.put("https://szcdn.ragalahari.com/oct2016/photosessions/pooja-sree-glam-hd-stills/", "pooja-sree-glam-hd-stills"); //26
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/pooja-sree-glam-photos/", "pooja-sree-glam-photos"); //27
		downloadFiles.put("https://szcdn.ragalahari.com/sep2016/photosessions/pooja-sree-glam-stills-in-yellow-dress/", "pooja-sree-glam-stills-in-yellow-dress"); //28
		downloadFiles.put("https://szcdn.ragalahari.com/sep2016/posters/actress-pooja-sree-glam-photos/", "actress-pooja-sree-glam-photos"); //29
		downloadFiles.put("https://szcdn.ragalahari.com/sep2016/posters/pooja-sri-red-dress-akritti/", "pooja-sri-red-dress-akritti"); //30
		downloadFiles.put("https://szcdn.ragalahari.com/sep2016/starzone/pooja-sree-cottage-craft-mela/", "pooja-sree-cottage-craft-mela"); //31
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/pooja-sree-red-dress-ragalahari/", "pooja-sree-red-dress-ragalahari"); //32
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/pooja-sree-ragalahari-photoshoot/", "pooja-sree-ragalahari-photoshoot");//33
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/pooja-sri-glam-stillls/", "pooja-sri-glam-stillls"); //34
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/posters/waffle-house-poojasree/", "waffle-house-poojasree"); //35
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/posters/pooja-sree-hilife-exhibition/", "pooja-sree-hilife-exhibition"); //36
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/starzone/pooja-sree-red/", "pooja-sree-red"); //37
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/photosessions/heroine-pooja-sree-hd-wallpapers/", "heroine-pooja-sree-hd-wallpapers"); //38
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/posters/poojasri-red-dress/", "poojasri-red-dress"); //39
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/posters/pooja-sri-wallpapers/", "pooja-sri-wallpapers"); //40
		downloadFiles.put("https://szcdn.ragalahari.com/july2016/posters/pooja-sri-hq-photos/", "pooja-sri-hq-photos"); //41
		downloadFiles.put("https://szcdn.ragalahari.com/july2016/starzone/pooja-sri-in-green-dress/", "pooja-sri-in-green-dress"); //42
		downloadFiles.put("https://szcdn.ragalahari.com/july2016/posters/poojasri-atrangi-exhibition/", "poojasri-atrangi-exhibition"); //43
		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/pooja-sri-heroine/", "pooja-sri-heroine"); //44
		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/pooja-shree-khan-saab-restaurant/", "pooja-shree-khan-saab-restaurant"); //45
		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/poojasri/", "poojasri"); //46
		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/poojasri-yoga/", "poojasri-yoga"); //47
		downloadFiles.put("https://szcdn.ragalahari.com/april2016/starzone/poojashree/", "poojashree"); //48
		downloadFiles.put("https://szcdn.ragalahari.com/aug2015/starzone/poojasree-at-pochampally-ikat-mela/", "poojasree-at-pochampally-ikat-mela"); //49
		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/starzone/poojasri-aiina-women-award-pressmeet/", "poojasri-aiina-women-award-pressmeet"); //50
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/poojasri-weekend-love-pressmeet/", "poojasri-weekend-love-pressmeet"); //51
*/
/*		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2020/photosessions/monica-thompson-red-mini-dress-crop-check-shirt/", "monica-thompson-red-mini-dress-crop-check-shirt");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2019/photosessions/monica-thompson-red-velvet-bodycon-rps/", "monica-thompson-red-velvet-bodycon-rps"); //2
		downloadFiles.put("https://szcdn.ragalahari.com/oct2019/photosessions/monica-thomson-gold-saree-rps/", "monica-thomson-gold-saree-rps"); //3
		downloadFiles.put("https://szcdn.ragalahari.com/oct2019/photosessions/monica-thompson-striped-mini-dress-rps/", "monica-thompson-striped-mini-dress-rps"); //4
		downloadFiles.put("https://szcdn.ragalahari.com/aug2019/photosessions/monica-thompson-red-mini-dress-rps/", "monica-thompson-red-mini-dress-rps"); //5
		downloadFiles.put("https://szcdn.ragalahari.com/july2019/photosessions/monica-thompson-black-lehenga-rps/", "monica-thompson-black-lehenga-rps"); //6
		downloadFiles.put("https://szcdn.ragalahari.com/mar2019/photosessions/monica-thompson-black-biker-jacket/", "monica-thompson-black-biker-jacket"); //7
		downloadFiles.put("https://szcdn.ragalahari.com/aug2017/photosessions/monica-thompson-designer-dress-shoot/", "monica-thompson-designer-dress-shoot"); //8
		downloadFiles.put("https://szcdn.ragalahari.com/aug2017/photosessions/monica-thompson-red-long-skirt/", "monica-thompson-red-long-skirt"); //9
		downloadFiles.put("https://szcdn.ragalahari.com/july2017/photosessions/monica-thompson-glam-hd-stills/", "monica-thompson-glam-hd-stills"); //10
		downloadFiles.put("https://szcdn.ragalahari.com/july2017/photosessions/monika-thompson-glam-mini-frock-stills/", "monika-thompson-glam-mini-frock-stills"); //11
		downloadFiles.put("https://szcdn.ragalahari.com/july2017/photosessions/monica-thompson-glam-stills-in-shorts/", "monica-thompson-glam-stills-in-shorts"); //12
		downloadFiles.put("https://szcdn.ragalahari.com/mar2016/starzone/monica-thompson/", "monica-thompson");//14
		downloadFiles.put("https://szcdn.ragalahari.com/feb2016/photosessions/hyderabad-girl-model-india-monica-thompson/", "hyderabad-girl-model-india-monica-thompson"); //15
		downloadFiles.put("https://szcdn.ragalahari.com/feb2016/starzone/monica-thompson-spicy-at-fashion-show/", "monica-thompson-spicy-at-fashion-show"); //16
		downloadFiles.put("https://szcdn.ragalahari.com/feb2016/starzone/monica-thompson-playboy/", "monica-thompson-playboy"); //17
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/photosessions/monica-thompson-actress-hot-stills-ragalahari/", "monica-thompson-actress-hot-stills-ragalahari"); //18
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/photosessions/tamil-actress-monica-thompson-photos/", "tamil-actress-monica-thompson-photos"); //19
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/photosessions/monica-thompson-model-ragalahari-photos/", "monica-thompson-model-ragalahari-photos"); //20
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/posters/thompson-monica/", "thompson-monica"); //21
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/starzone/monica-thompson-playboy/", "monica-thompson-playboy"); //22
		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/photosessions/monica-thompson-in-designer-dress/", "monica-thompson-in-designer-dress"); //23
		downloadFiles.put("https://szcdn.ragalahari.com/dec2015/photosessions/monica-thompson-model-ragalahari-photos/", "monica-thompson-model-ragalahari-photos"); //24
		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/posters/monica-thompson-posing-for-camera/", "monica-thompson-posing-for-camera"); //24 2
		downloadFiles.put("https://szcdn.ragalahari.com/oct2015/photosessions/monica-thompson-india-model-wallpapers/", "monica-thompson-india-model-wallpapers"); //26
		downloadFiles.put("https://szcdn.ragalahari.com/oct2015/posters/monica_thompson_wallpapers/", "monica_thompson_wallpapers"); //27
		downloadFiles.put("https://szcdn.ragalahari.com/sept2015/photosessions/monica-thompson-gallery-ragalahari/", "monica-thompson-gallery-ragalahari"); //28
		downloadFiles.put("https://szcdn.ragalahari.com/sept2015/photosessions/monica_thompson_hyderabad_model/", "monica_thompson_hyderabad_model"); //29
		downloadFiles.put("https://szcdn.ragalahari.com/sept2015/photosessions/monica_thompson_hyderabad_model/", "monica_thompson_hyderabad_model"); //30
		downloadFiles.put("https://szcdn.ragalahari.com/aug2015/hd/monica-thompson-hot-pics/", "monica-thompson-hot-pics"); // 31
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2015/posters/monica-thompson/", "monica-thompson");
*/
		
//		downloadFiles.put("https://starzone.ragalahari.com/mar2022/hd/lavanya-sharma-anm-madhuravaani-launch/", "lavanya-sharma-anm-madhuravaani-launch");
/*		
		downloadFiles.put("https://szcdn.ragalahari.com/nov2018/photosessions/tanusha-white-top-jeans/", "tanusha-white-top-jeans");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2018/photosessions/tanusha-swathi-in-chudidar/", "tanusha-swathi-in-chudidar");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2018/photosessions/tanusha-swathi-photoshoot/", "tanusha-swathi-photoshoot"); //3
		downloadFiles.put("https://szcdn.ragalahari.com/jan2018/photosessions/tanusha/", "tanusha"); //4
		downloadFiles.put("https://szcdn.ragalahari.com/nov2017/photosessions/tanusha-ragalahari-photoshoot/", "tanusha-ragalahari-photoshoot"); //6
		downloadFiles.put("https://szcdn.ragalahari.com/feb2017/posters/swathi-tanusha-in-black-long-frock/", "swathi-tanusha-in-black-long-frock"); //7
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/posters/tanusha-at-priyaandluri-birthday/", "tanusha-at-priyaandluri-birthday"); //8
		downloadFiles.put("https://szcdn.ragalahari.com/oct2014/photosessions/tollywood-actress-tanusha/", "tollywood-actress-tanusha"); //12
		downloadFiles.put("https://szcdn.ragalahari.com/may2014/photosessions/tanusha-swathi-in-half-saree/", "tanusha-swathi-in-half-saree"); //14
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tollywood-heroine-tanusha/", "tollywood-heroine-tanusha"); //27
		downloadFiles.put("https://szcdn.ragalahari.com/jan2014/photosessions/tanusha-in-blue-skirt/", "tanusha-in-blue-skirt"); //22
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/photosessions/tanusha-black-top/", "tanusha-black-top"); //23
		downloadFiles.put("https://imgcdn.ragalahari.com/june2013/photosessions/heroine-tanusha-hot-pics/", "heroine-tanusha-hot-pics"); //31
		downloadFiles.put("https://szcdn.ragalahari.com/july2012/photosessions/tanusha-ragalahari-studio-shoot/", "tanusha-ragalahari-studio-shoot"); //42
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/photosessions/telugu-heroine-tanusha-ps/", "telugu-heroine-tanusha-ps"); //41
*/
/*		
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/photosessions/tv-artist-deepthi-naidu-photo-session/", "tv-artist-deepthi-naidu-photo-session");
		downloadFiles.put("https://img.ragalahari.com/feb2012/starzone/deepthi2-blue-black-dress-ragalahari-ps/", "deepthi2-blue-black-dress-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2011/starzone/deepthi2-reddress-ragalahari-ps/", "deepthi2-reddress-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2011/starzone/deepthi2-half-saree-ragalahari-ps/", "deepthi2-half-saree-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/july2011/starzone/deepthi2-pinkdress-ragalahari-ps/", "deepthi2-pinkdress-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/april2011/starzone/deepthi2-rose-ragalahari-photosession/", "deepthi2-rose-ragalahari-photosession");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2011/starzone/deepthi2-whitedress-photosession/", "deepthi2-whitedress-photosession");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2010/starzone/deepthi-ragalahari-session/", "deepthi-ragalahari-session");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2010/starzone/deepthi-high-resolution-portfolio/", "deepthi-high-resolution-portfolio");
*/
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2018/photosessions/rhithya-perera-saree-photoshoot/", "rhithya-perera-saree-photoshoot10");
//		downloadFiles.put("https://szcdn1.ragalahari.com/april2012/starzone/hyderabad-model-sravanthi-photo-session/", "hyderabad-model-sravanthi-photo-session");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2016/photosessions/sravanthi-telugu-heroine-photos/", "sravanthi-telugu-heroine-photos");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2014/starzone/sravanthi-hot-pics/", "sravanthi-hot-pics");
/*
		downloadFiles.put("https://szcdn.ragalahari.com/april2014/hd/green-signal-shilpi-sharma-hot-photos/", "green-signal-shilpi-sharma-hot-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2014/starzone/shilpasharma-khwaish-womensday-exhibition/", "shilpasharma-khwaish-womensday-exhibition");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/starzone/shilpi-shah-little-kids-exhibition-launch/", "shilpi-shah-little-kids-exhibition-launch");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/starzone/shilpi-sharma-hot-pics/", "shilpi-sharma-hot-pics");
		downloadFiles.put("https://imgcdn.ragalahari.com/april2014/starzone/shilpi-sharma-hot-photos/", "shilpi-sharma-hot-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/may2014/starzone/shilpi-sharma-in-green-top/", "shilpi-sharma-in-green-top");
		downloadFiles.put("https://szcdn.ragalahari.com/may2014/starzone/heroine-shilpisharma/", "heroine-shilpisharma155t.jpg"); //3
*/
/*		
		downloadFiles.put("https://szcdn.ragalahari.com/july2010/starzone/sunshine-thailand/", "sunshine-thailand");
		downloadFiles.put("https://szcdn.ragalahari.com/july2010/starzone/heroine-sunakshi5/", "heroine-sunakshi5");
		downloadFiles.put("https://szcdn.ragalahari.com/july2010/starzone/sunkashi-gallery4/", "sunkashi-gallery4");
		downloadFiles.put("https://starzone.ragalahari.com/july2010/starzone/heroine-sunakshi6/", "heroine-sunakshi6");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2010/starzone/sunakshi-high-resolution/", "sunakshi-high-resolution");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2010/starzone/sunakshi-sankranthi-alludu/", "sunakshi-sankranthi-alludu");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2010/starzone/sunakshi-spicy-gallery/", "sunakshi-spicy-gallery");
		downloadFiles.put("https://szcdn.ragalahari.com/july2010/starzone/sunakshi-spicy-gallery2/", "sunakshi-spicy-gallery2");
		downloadFiles.put("https://szcdn.ragalahari.com/july2010/starzone/sunakshi-photo-gallery/", "sunakshi-photo-gallery");
*/
/*		
		downloadFiles.put("https://szcdn.ragalahari.com/jan2010/starzone/tanishatwo6/", "tanishatwo6");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2010/starzone/tanishatwo5/", "tanishatwo5");
		downloadFiles.put("https://media.ragalahari.com/dec2009/starzone/tanishatwo4/", "tanishatwo4");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2009/starzone/tanishatwo3/", "tanishatwo3");
		downloadFiles.put("https://szcdn.ragalahari.com/august2009/starzone/tanishatwo2/", "tanishatwo2");
		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/tanishatwo1/", "tanishatwo1");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2010/starzone/tanishatwo/", "tanishatwo");
*/
/*
 		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/soniatwo1/", "soniatwo1");
		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/kausha17/", "kausha17");
		downloadFiles.put("https://media.ragalahari.com/gallery/kausha/", "kausha");
		downloadFiles.put("https://img.ragalahari.com/gallery/kaushanov/", "kaushanov");
		downloadFiles.put("https://img.ragalahari.com/gallery/kaushaathili/", "kaushaathili");
		downloadFiles.put("https://img.ragalahari.com/gallery/kaushabuddha/", "kaushabuddha");
		downloadFiles.put("https://img.ragalahari.com/gallery/kaushaphoto/", "kaushaphoto");
		downloadFiles.put("https://img.ragalahari.com/gallery/kausha6/", "kausha6");
		downloadFiles.put("https://img.ragalahari.com/gallery/kausha7/", "kausha7");
		downloadFiles.put("https://img.ragalahari.com/gallery/kausha8/", "kausha8");
		downloadFiles.put("https://img.ragalahari.com/gallery/kausha9/", "kausha9");
		downloadFiles.put("https://starzone.ragalahari.com/march2008gallery/kausha10/", "kausha10");
		downloadFiles.put("https://starzone.ragalahari.com/may2008gallery/kausha11/", "kausha11");
		downloadFiles.put("https://starzone.ragalahari.com/july2008gallery/kausha12/", "kausha12");
		downloadFiles.put("https://media.ragalahari.com/september2008gallery/kausha13/", "kausha13");
		downloadFiles.put("https://media.ragalahari.com/november2008gallery/kausha14/", "kausha14");
		downloadFiles.put("https://szcdn.ragalahari.com/december2008gallery/kausha15/", "kausha15");
		downloadFiles.put("https://szcdn.ragalahari.com/march2009/starzone/kausha16/", "kausha16");
		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/kausha17/", "kausha17");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2009/starzone/kausha19/", "kausha19");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2010/starzone/kausha20/", "kausha20");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2010/starzone/kausha-spicy-gallery/", "kausha-spicy-gallery1");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2010/starzone/kausha-high-resolution/", "kausha-high-resolution");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2010/starzone/kausha-high-resolution-kireetam-audio/", "kausha-high-resolution-kireetam-audio");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2010/starzone/kausha-high-resolution-gallery/", "kausha-high-resolution-gallery");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2011/starzone/kousha-photo-gallery-new/", "kousha-photo-gallery-new");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/posters/kausha-red-alert/", "kausha-red-alert");
*/		
//		downloadFiles.put("https://starzone.ragalahari.com/april2009/starzone/isha1/", "isha1");		
//		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tashu-kaushik-shoulderless-yellow-dress/", "tashu-kaushik-shoulderless-yellow-dress1t.jpg");
/*		
		downloadFiles.put("https://img.ragalahari.com/april2015/photosessions/tashukaushik-wallpapers/", "tashukaushik-wallpapers");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/photosessions/tashu-kaushik-facebook/", "tashu-kaushik-facebook");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/photosessions/tashu-kaushik-wiki/", "tashu-kaushik-wiki");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2014/photosessions/indian-film-actress-tashu-kaushik/", "indian-film-actress-tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/febraury2009gallery/starzone/tashukaushik2/", "tashukaushik2");
		downloadFiles.put("https://szcdn.ragalahari.com/may2014/photosessions/bengali-actress-tashu-kaushik/", "bengali-actress-tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/april2014/photosessions/tashu-kaushik-blue-dress-photo-shoot/", "tashu-kaushik-blue-dress-photo-shoot");
		downloadFiles.put("https://imgcdn.ragalahari.com/mar2014/photosessions/sandalwood-heroine-tashukaushik-photoshoot/", "sandalwood-heroine-tashukaushik-photoshoot");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2014/photosessions/beautiful-indian-woman-photos/", "beautiful-indian-woman-photos"); //3
		downloadFiles.put("https://szcdn.ragalahari.com/feb2014/photosessions/tashu-kaushik-expressions-photoshoot/", "tashu-kaushik-expressions-photoshoot");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2014/photosessions/tashu-kaushik-posing-in-blue-saree/", "tashu-kaushik-posing-in-blue-saree");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/starzone/tashukaushik-reporter-teaser-launch/", "tashukaushik-reporter-teaser-launch");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2013/photosessions/tashu-kaushik-in-her-yellow-top/", "tashu-kaushik-in-her-yellow-top"); //4
		downloadFiles.put("https://szcdn.ragalahari.com/nov2013/photosessions/tashu-kaushik-in-long-blue-skirt/", "tashu-kaushik-in-long-blue-skirt");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2013/photosessions/tashu-kaushik-goa-ragalahari-shoot/", "tashu-kaushik-goa-ragalahari-shoot");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2013/photosessions/tashu-kaushik-black-western-dress/", "tashu-kaushik-black-western-dress");//5
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tashu-kaushik-shoulderless-yellow-dress/", "tashu-kaushik-shoulderless-yellow-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tashu-kaushik-in-green-dress/", "tashu-kaushik-in-green-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tamil-actress-tashu-kaushik/", "tamil-actress-tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/stylish-tashu-kaushik/", "stylish-tashu-kaushik"); //6
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/pazhaya-vannarapettai-heroine/", "pazhaya-vannarapettai-heroine");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/photosessions/tashu-kaushik-blue-saree/", "tashu-kaushik-blue-saree");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/starzone/tashu-kaushik-reporter-sets/", "tashu-kaushik-reporter-sets");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2013/hd/tashu-kaushik-portfolio-photos/", "tashu-kaushik-portfolio-photos"); //7
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/telugu-heroine-tashu-kaushik/", "telugu-heroine-tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/annum-innum-ennum-heroine-tashu-kaushik/", "annum-innum-ennum-heroine-tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/bollywood-heroine-tashu-kaushik/", "bollywood-heroine-tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013//photosessions/tashu-kaushik-glamorous-photos/", "tashu-kaushik-glamorous-photos"); //8
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/posters/tashu-kaushik-pink-dress/", "tashu-kaushik-pink-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/hd/tashu-kaushik/", "tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/photosessions/tashu-kaushik-ragalahari-exclusive-outdoor/", "tashu-kaushik-ragalahari-exclusive-outdoor");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/photosessions/tollywood-heroine-tashu-kaushik/", "tollywood-heroine-tashu-kaushik"); //9
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/photosessions/tashu-kaushik-beach-shoot/", "tashu-kaushik-beach-shoot");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/photosessions/tashu-kaushik-black-dress/", "tashu-kaushik-black-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/hd/tashu-kaushik-latest-portfolio/", "tashu-kaushik-latest-portfolio");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/tashu-kaushik-metro-heights-lucky-draw/", "tashu-kaushik-metro-heights-lucky-draw"); //10
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/tashu-kaushik-vegham-audio/", "tashu-kaushik-vegham-audio");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/tashu-kaushik-khwaish-curtain-raiser/", "tashu-kaushik-khwaish-curtain-raiser");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/tashu-kaushik-patny-jewellers/", "tashu-kaushik-patny-jewellers");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/tashu-kaushik-redsalwar-radiomirchi/", "tashu-kaushik-redsalwar-radiomirchi"); //11
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/photosessions/tashu-kaushik-garden-shoot/", "tashu-kaushik-garden-shoot");
		downloadFiles.put("https://szcdn.ragalahari.com/april2013/starzone/tashukaushik-golaseenu-sm/", "tashukaushik-golaseenu-sm");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/posters/tashu-kaushik-spicy-photos/", "tashu-kaushik-spicy-photos");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/starzone/tashu-kaushik-aircel-3goffer/", "tashu-kaushik-aircel-3goffer"); //12
		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/posters/tashu-kaushik-telugabbai-pressmeet/", "tashu-kaushik-telugabbai-pressmeet");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/photosessions/cool-ganesha-heroine-tashu/", "cool-ganesha-heroine-tashu");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2013/posters/south-indian-heroine-tashu-kaushik-saree-stills/", "south-indian-heroine-tashu-kaushik-saree-stills");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2013/starzone/tashu-kaushik-gola-seenu-audio/", "tashu-kaushik-gola-seenu-audio"); //13
		downloadFiles.put("https://szcdn.ragalahari.com/jan2013/photosessions/tashu-kaushik-terrace-shoot/", "tashu-kaushik-terrace-shoot");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/starzone/tashu-kaushik-2012-bumper-draw/", "tashu-kaushik-2012-bumper-draw");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/hd/tashu-kaushik-hot-photos/", "tashu-kaushik-hot-photos"); //14
		downloadFiles.put("https://szcdn.ragalahari.com/dec2012/photosessions/tashu-kaushik-short-jean-ps/", "tashu-kaushik-short-jean-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2012/hd/tashu-kaushik-in-maldives/", "tashu-kaushik-in-maldives");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/photosessions/tashu-kaushik-birthday/", "tashu-kaushik-birthday");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2012/photosessions/tashu-kaushik-garden/", "tashu-kaushik-garden"); //15
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/hd/tashu-kaushik-beach-mini-skirt-hd/", "tashu-kaushik-beach-mini-skirt-hd");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/posters/tashu-kaushik-white-lace-top-beach-wear/", "tashu-kaushik-white-lace-top-beach-wear");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/hd/tashu-kaushik-glamour-photos-hd/", "tashu-kaushik-glamour-photos-hd");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/hd/beautiful-tashu-kaushik-white-midriff-dress-hd/", "beautiful-tashu-kaushik-white-midriff-dress-hd");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/photosessions/tashu-kaushik-black-and-white/", "tashu-kaushik-black-and-white");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/photosessions/cool-ganesha-heroine-tashu-kaushik/", "cool-ganesha-heroine-tashu-kaushik"); //17
		downloadFiles.put("https://szcdn.ragalahari.com/sept2012/photosessions/tashu-kaushik-short-gown-outdoor-shoot/", "tashu-kaushik-short-gown-outdoor-shoot"); //17
		downloadFiles.put("https://szcdn.ragalahari.com/aug2012/hd/tashu-kaushik-hd-portfolio/", "tashu-kaushik-hd-portfolio");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tashu-kaushik-in-green-dress/", "tashu-kaushik-in-green-dress");
		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/tamil-actress-tashu-kaushik/", "tamil-actress-tashu-kaushik");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2012/starzone/tashu-kaushik-srimannarayana-audio/", "tashu-kaushik-srimannarayana-audio"); //18
		downloadFiles.put("https://szcdn.ragalahari.com/aug2012/starzone/tashu-kaushik-hiya-designer-jewellery/", "tashu-kaushik-hiya-designer-jewellery");
		downloadFiles.put("https://szcdn1.ragalahari.com/aug2012/starzone/tashukaushik-santosham-awards-2012-curtain-raiser/", "tashukaushik-santosham-awards-2012-curtain-raiser");
		downloadFiles.put("https://szcdn.ragalahari.com/july2012/starzone/tashu-kaushik-neerus-elite-6th-anniversary/", "tashu-kaushik-neerus-elite-6th-anniversary");
		downloadFiles.put("https://szcdn.ragalahari.com/july2012/photosessions/tashu-kaushik-ragalahari-outdoor-shoot/", "tashu-kaushik-ragalahari-outdoor-shoot"); //19
		downloadFiles.put("https://szcdn.ragalahari.com/july2012/starzone/tashu-kaushik-telugabbayi-audio/", "tashu-kaushik-telugabbayi-audio");
		downloadFiles.put("https://szcdn1.ragalahari.com/april2012/starzone/tashu-kaushik-hires-amori/", "tashu-kaushik-hires-amori");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2011/starzone/tashu-kaushik-highres-agrigold/", "tashu-kaushik-highres-agrigold");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2011/starzone/tashu-kaushik-black-gown-ragalahari-ps/", "tashu-kaushik-black-gown-ragalahari-ps"); //20
		downloadFiles.put("https://szcdn.ragalahari.com/sept2011/starzone/tashu-kaushik-highres-dabur/", "tashu-kaushik-highres-dabur");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2011/starzone/tashu-kaushik-blackgown-ragalahari-ps/", "tashu-kaushik-blackgown-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2011/starzone/tashu-kaushik-highres-neerus/", "tashu-kaushik-highres-neerus");
		downloadFiles.put("https://szcdn.ragalahari.com/july2011/starzone/tashu-kaushik-high-resolution-neerus/", "tashu-kaushik-high-resolution-neerus"); //21
		downloadFiles.put("https://szcdn.ragalahari.com/july2011/starzone/tashu-kaushik-colours-ragalahari-ps/", "tashu-kaushik-colours-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/june2011/starzone/tashu-kaushik-high-resolution-inorbit-mall/", "tashu-kaushik-high-resolution-inorbit-mall");
		downloadFiles.put("https://szcdn.ragalahari.com/june2011/starzone/tashu-kaushik-high-resolution-ccl/", "tashu-kaushik-high-resolution-ccl");
		downloadFiles.put("https://szcdn.ragalahari.com/june2011/starzone/tashu-kaushik-high-resolution-mebaz/", "tashu-kaushik-high-resolution-mebaz"); //22
		downloadFiles.put("https://szcdn.ragalahari.com/june2011/starzone/tashu-kaushik-high-resolution-meena-jewellers/", "tashu-kaushik-high-resolution-meena-jewellers");
		downloadFiles.put("https://szcdn.ragalahari.com/may2011/starzone/tashu-kaushik-caravan-high-resolution/", "tashu-kaushik-caravan-high-resolution");
		downloadFiles.put("https://szcdn.ragalahari.com/may2011/starzone/tashukoushik-colours-ragalahari-ps/", "tashukoushik-colours-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/may2011/starzone/tashu-kaushik-high-resolution-vykuntapali-spicy/", "tashu-kaushik-high-resolution-vykuntapali-spicy"); //23
		downloadFiles.put("https://szcdn.ragalahari.com/may2011/starzone/tashu-kaushik-high-resolution-vykuntapali-pm/", "tashu-kaushik-high-resolution-vykuntapali-pm");
		downloadFiles.put("https://szcdn.ragalahari.com/may2011/starzone/tashu-kaushik-high-resolution-dussasana/", "tashu-kaushik-high-resolution-dussasana");
		downloadFiles.put("https://szcdn.ragalahari.com/may2011/starzone/tashu-kaushik-high-resolution-hospitality-awards/", "tashu-kaushik-high-resolution-hospitality-awards");
		downloadFiles.put("https://img.ragalahari.com/may2011/starzone/tashu-kaushik-high-resolution-golkonda/", "tashu-kaushik-high-resolution-golkonda"); //24
		downloadFiles.put("https://szcdn.ragalahari.com/april2011/starzone/tashu-koushik-white-ragalahari-ps/", "tashu-koushik-white-ragalahari-ps");
		downloadFiles.put("https://szcdn.ragalahari.com/april2011/starzone/tashu-kaushik-high-resolution-cmr/", "tashu-kaushik-high-resolution-cmr");
		downloadFiles.put("https://szcdn.ragalahari.com/april2011/starzone/tashu-kaushik-gray-ragalahari-photosession/", "tashu-kaushik-gray-ragalahari-photosession");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2011/starzone/tashu-kaushik-high-resolution-bajaj/", "tashu-kaushik-high-resolution-bajaj"); //25
		downloadFiles.put("https://starzone.ragalahari.com/mar2011/starzone/tashu-kaushik-high-resolution-rubys/", "tashu-kaushik-high-resolution-rubys");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2011/starzone/tashu-kaushik-high-resolution-rubys/", "tashu-kaushik-high-resolution-rubys");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2011/starzone/heroine-tashu-kaushik-high-resolution/", "heroine-tashu-kaushik-high-resolution");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2011/starzone/tashu-kaushik-high-resolution-vaikuntapaali/", "tashu-kaushik-high-resolution-vaikuntapaali"); //26
		downloadFiles.put("https://szcdn.ragalahari.com/jan2011/starzone/tashu-kaushik-high-resolution-graduate/", "tashu-kaushik-high-resolution-graduate");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2011/starzone/tashu-kaushik-graduate-high-resolution/", "tashu-kaushik-graduate-high-resolution");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2010/starzone/tashu-kaushik-high-resolution-graduate/", "tashu-kaushik-high-resolution-graduate");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2010/starzone/tashu-kaushik-high-resolution/", "tashu-kaushik-high-resolution"); //27
		downloadFiles.put("https://szcdn.ragalahari.com/oct2010/starzone/tashukoushik-dussasana-opening/", "tashukoushik-dussasana-opening");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2009/starzone/tashukaushik13/", "tashukaushik13");
		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/tashukaushik12/", "tashukaushik12");
		downloadFiles.put("https://szcdn.ragalahari.com/july2009/starzone/tashukaushik11/", "tashukaushik11"); //28
		downloadFiles.put("https://szcdn.ragalahari.com/june2009/starzone/tashukaushik10/", "tashukaushik10");
		downloadFiles.put("https://media1.ragalahari.com/june2009/starzone/tashukaushik9/", "tashukaushik9");
		downloadFiles.put("https://szcdn.ragalahari.com/may2009/starzone/tashukaushik8/", "tashukaushik8");//
		downloadFiles.put("https://szcdn.ragalahari.com/may2009/starzone/tashukaushik7/", "tashukaushik7"); //29
		downloadFiles.put("https://szcdn.ragalahari.com/april2009/starzone/tashukaushik6/", "tashukaushik6");
		downloadFiles.put("https://media.ragalahari.com/march2009/starzone/tashukaushik5/", "tashukaushik5");
		downloadFiles.put("https://media.ragalahari.com/march2009/starzone/tashukaushik4/", "tashukaushik4");
		downloadFiles.put("https://szcdn.ragalahari.com/march2009/starzone/tashukaushik3/", "tashukaushik3"); //30
		downloadFiles.put("https://szcdn.ragalahari.com/febraury2009gallery/starzone/tashukaushik2/", "tashukaushik2");
		downloadFiles.put("https://szcdn.ragalahari.com/febraury2009gallery/starzone/surveenchawla1/", "surveenchawla1");
		*/
//		downloadFiles.put("https://szcdn.ragalahari.com/july2013/photosessions/model-bhargavi-ragalahari-photo-shoot/", "model-bhargavi-ragalahari-photo-shoot,212");
//		downloadFiles.put("https://imgcdn.ragalahari.com/mar2015/starzone/chamundi-bluemoon/", "chamundi-bluemoon,20");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2014/photosessions/actress-chamundi-portfolio/", "actress-chamundi-portfolio,124");
//		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/starzone/heroine-in-saree/", "heroine-in-saree,107");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2016/starzone/telugu-actress-eesha/", "telugu-actress-eesha,228");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/sneha-thakur-spicy-pics/", "sneha-thakur-spicy-pics");
		
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2015/hd/siri-sri-ee-cinema-superhit-guarantee/", "siri-sri-ee-cinema-superhit-guarantee");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2012/starzone/sree-siri-traditional-gallery/", "sree-siri-traditional-gallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2014/starzone/siri-chakkiligintha-audio/", "siri-chakkiligintha-audio");
//		downloadFiles.put("https://szcdn1.ragalahari.com/nov2013/starzone/sirisri-broker2-on-the-sets/", "sirisri-broker2-on-the-sets");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2012/starzone/sree-siri-photogallery/", "sree-siri-photogallery");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2011/starzone/sree-siri-high-resolution/", "sree-siri-high-resolution");
//		https://szcdn.ragalahari.com/june2013/photosessions/indian-supermodel-seethal-sidge/indian-supermodel-seethal-sidge170t.jpg
//		https://szcdn.ragalahari.com/june2013/photosessions/indian-supermodel-seethal-sidge/indian-supermodel-seethal-sidge1, 7055.jpg

//		downloadFiles.put("https://szcdn.ragalahari.com/june2013/photosessions/indian-supermodel-seethal-sidge/", "indian-supermodel-seethal-sidge1, 70");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2013/photosessions/indian-supermodel-seethal-sidge/", "indian-supermodel-seethal-sidge,170");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2013/photosessions/vasundhara-ragalahari-shoot/", "vasundhara-ragalahari-shoot,51");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2022/hd/gehna-sippy-gaalodu-pre-release-event/", "gehna-sippy-gaalodu-pre-release-event,49");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2018/posters/kalpika-ganesh-my-dear-marthandam-pm/", "kalpika-ganesh-my-dear-marthandam-pm,75");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2018/posters/kalpika-pplm-pre-release/", "kalpika-pplm-pre-release,38");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2013/starzone/telugu-heroine-neetu-agarwal/", "telugu-heroine-neetu-agarwal,57");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/ramya-raj-weekend-party-audio-launch/", "ramya-raj-weekend-party-audio-launch,32");		
//		downloadFiles.put("https://szcdn.ragalahari.com/july2015/photosessions/hyderabad-film-actress-shalu-chourasiya/", "hyderabad-film-actress-shalu-chourasiya,171");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/photosessions/telugu-movie-actress-shalu-chourasiya/", "telugu-movie-actress-shalu-chourasiya,129");
//		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/hd/shalu-chourasiya-high-definition-wallpapers/", "shalu-chourasiya-high-definition-wallpapers,125");
//		downloadFiles.put("https://imgcdn.ragalahari.com/july2015/photosessions/shaluchourasiya-ragalahari-studio-shoot/", "shaluchourasiya-ragalahari-studio-shoot,154");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2022/photosessions/deepika-chaurasia-red-gray-lehenga-rps/", "deepika-chaurasia-red-gray-lehenga-rps,224");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2011/starzone/eesha-red-dress-ragalahari-ps/", "eesha-red-dress-ragalahari-ps,110");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2019/hd/eesha-rebba-ragala-24gantallo-inter/", "eesha-rebba-ragala-24gantallo-inter,140");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/priya-vadlamani-mukhachitran-interview/", "priya-vadlamani-mukhachitran-interview,70");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2014/photosessions/chandamama-kathalu-heroine-isha-ranganath/","chandamama-kathalu-heroine-isha-ranganath,227");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2014/photosessions/kannada-actress-isha-ranganath/","kannada-actress-isha-ranganath,107");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2022/photosessions/anusha-parada-lily-green-lehenga-rps/", "anusha-parada-lily-green-lehenga-rps,150");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2022/photosessions/deepika-chaurasia-red-gray-lehenga-rps/", "deepika-chaurasia-red-gray-lehenga-rps,224");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2022/photosessions/tanya-pradhan-yellow-lehenga-choli-rps/", "tanya-pradhan-yellow-lehenga-choli-rps,112");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2017/photosessions/harshada-patil-hd-wallpapers/", "harshada-patil-hd-wallpapers,160");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2021/photosessions/aadita-surbhi-jain-red-sequin-bodycon-rps/", "aadita-surbhi-jain-red-sequin-bodycon-rps,26");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2019/hd/saritha-musuku-sanjana-anne-bday2019/", "saritha-musuku-sanjana-anne-bday2019,33");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2019/hd/saritha-musuku-miss-mrs-india-asia-auditions/", "saritha-musuku-miss-mrs-india-asia-auditions,69");
//		downloadFiles.put("https://szcdn.ragalahari.com/may2019/posters/saritha-musuku-burrakatha-teaser/", "saritha-musuku-burrakatha-teaser,18");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2018/starzone/saritha-red-dress/", "saritha-red-dress,11");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2018/starzone/saritha-red-dress/", "saritha-red-dress10,17");
//		downloadFiles.put("https://szcdn.ragalahari.com/june2018/starzone/saritha-red-dress/", "saritha-red-dress,11");
//		downloadFiles.put("https://szcdn.ragalahari.com/sept2015/starzone/saritha-club-republic/", "saritha-club-republic,55");
//		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/starzone/saritha/", "saritha,29");
//		downloadFiles.put("https://imgcdn.ragalahari.com/dec2014/starzone/saritha/", "saritha,17");
//		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/saritha/", "saritha,11");
//		downloadFiles.put("https://szcdn.ragalahari.com/april2021/photosessions/aadita-surbhi-jain-red-sequin-bodycon-rps/", "aadita-surbhi-jain-red-sequin-bodycon-rps,26");
//		downloadFiles.put("https://img.ragalahari.com/feb2010/starzone/shehatwo1/", "shehatwo1,93");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2010/starzone/sneha-spicy-gallery/", "sneha-spicy-gallery,37");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/ankita-saha-rajayogam-success-meet/", "ankita-saha-rajayogam-success-meet,56");
//		downloadFiles.put("https://szcdn.ragalahari.com/nov2022/hd/ankita-saha-rajayogam-teaser-launch/", "ankita-saha-rajayogam-teaser-launch,88");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/aparna-reddy-sutraa-exhibition-dec2022/", "aparna-reddy-sutraa-exhibition-dec2022,22");
/*		
		downloadFiles.put("https://szcdn.ragalahari.com/may2022/hd/shyamala-vikram-pre-release-event/", "shyamala-vikram-pre-release-event,37");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2022/hd/shyamala-thaggedele-pre-release-event/", "shyamala-thaggedele-pre-release-event,71");
		downloadFiles.put("https://szcdn.ragalahari.com/july2022/hd/shyamala-ladki-pre-release/", "shyamala-ladki-pre-release,50");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2022/hd/shyamala-rowdy-boys-musical-night/", "shyamala-rowdy-boys-musical-night,48");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2021/hd/shyamala-manchirojulochaie-pre-release/", "shyamala-manchirojulochaie-pre-release,70");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2021/hd/shyamala-love-story-success-meet/", "shyamala-love-story-success-meet,12");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2021/hd/shyamala-gully-rowdy-pre-release/", "shyamala-gully-rowdy-pre-release,102");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2021/hd/shyamala-maestro-pre-release-event/", "shyamala-maestro-pre-release-event,65");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2021/hd/shyamala-thalaivi-pre-release-event/", "shyamala-thalaivi-pre-release-event,56");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2021/hd/shyamala-house-arrest-pre-release/", "shyamala-house-arrest-pre-release,58");
		downloadFiles.put("https://szcdn.ragalahari.com/april2021/hd/shyamala-ishq-pre-release-event/", "shyamala-ishq-pre-release-event,70");
		downloadFiles.put("https://szcdn.ragalahari.com/april2021/hd/shyamala-major-press-meet/", "shyamala-major-press-meet,24");
		downloadFiles.put("https://szcdn.ragalahari.com/april2021/hd/shyamala-tuck-jagadish-press-meet/", "shyamala-tuck-jagadish-press-meet,63");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/shyamala-sulthan-pre-release/", "shyamala-sulthan-pre-release,134");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/shyamala-ram-charan-birthday2021/", "shyamala-ram-charan-birthday2021,28");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/syamala-thellavarithe-guruvaram-pre-release/", "syamala-thellavarithe-guruvaram-pre-release,50");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/shyamala-aranya-pre-release-event/", "shyamala-aranya-pre-release-event,31");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/shyamala-mosagallu-pre-release/", "shyamala-mosagallu-pre-release,48");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/shyamala-sashi-prerelease-event/", "shyamala-sashi-prerelease-event,48");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/starzone/shyamala-sreekaram-pre-release/", "shyamala-sreekaram-pre-release,47");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/shyamala-gaali-sampath-pre-release/", "shyamala-gaali-sampath-pre-release,49");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2021/hd/shyamala-shadi-mubharak-pre-release/", "shyamala-shadi-mubharak-pre-release,53");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2021/hd/shyamala-roberrt-pre-release-event/", "shyamala-roberrt-pre-release-event,54");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2021/hd/shyamala-black-white-choffon-saree/", "shyamala-black-white-choffon-saree,33");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2021/hd/shyamala-teal-blue-slit-dress/", "shyamala-teal-blue-slit-dress,36");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2021/hd/shyamala-uppena-success-meet-rajahmundry/", "shyamala-uppena-success-meet-rajahmundry,41");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2021/hd/shyamala-kapatadhaari-pre-release/", "shyamala-kapatadhaari-pre-release,48");
		downloadFiles.put("https://szcdn.ragalahari.com/feb2021/hd/shyamala-30-rojullo-thanks-meet/", "shyamala-30-rojullo-thanks-meet,92");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2021/hd/syamala-zombie-reddy-pre-release/", "syamala-zombie-reddy-pre-release,85");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/hd/shyamala-bangaru-bullodu-pre-release/", "shyamala-bangaru-bullodu-pre-release,89");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/hd/shyamala-krack-trailer-launch/", "shyamala-krack-trailer-launch,64");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2020/hd/shyamala-red-trailer-launch/", "shyamala-red-trailer-launch,44");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2020/hd/shyamala-question-mark-song-launch/", "shyamala-question-mark-song-launch,78");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2019/hd/syamala-rvrg-prerelease1/", "syamala-rvrg-prerelease,86");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2019/starzone/shyamala-gangleader-pre-release/", "shyamala-gangleader-pre-release,78");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2019/hd/shyamala-manmadhudu2-prerelease/", "shyamala-manmadhudu2-prerelease,40");
		downloadFiles.put("https://szcdn.ragalahari.com/june2019/hd/anchor-shymala-rajdoot-pre-release/", "anchor-shymala-rajdoot-pre-release,76");
		downloadFiles.put("https://szcdn.ragalahari.com/mar2019/posters/shyamala-suryakantham-pre/", "shyamala-suryakantham-pre,83");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2018/hd/shyamala-bullithera-awards-2018/", "shyamala-bullithera-awards-2018,9");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2018/posters/syamala-next-enti-pre-release/", "syamala-next-enti-pre-release,50");
		downloadFiles.put("https://szcdn.ragalahari.com/dec2018/starzone/shyamala-kavacham-audio-launch/", "shyamala-kavacham-audio-launch,14");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2018/starzone/shyamla-rangu-prerelease/", "shyamla-rangu-prerelease,21");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2018/posters/shyamala-blue-saree-designer-blouse/", "shyamala-blue-saree-designer-blouse,64");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2018/starzone/anchorshyamala-aravindasametha-sm/", "anchorshyamala-aravindasametha-sm,44");
//		downloadFiles.put("https://szcdn.ragalahari.com/sep2018/starzone/shyamala/", "shyamala1007");
		downloadFiles.put("https://szcdn.ragalahari.com/may2018/hd/shyamala-naa-peru-surya-thanks-meet/", "shyamala-naa-peru-surya-thanks-meet,15");
		downloadFiles.put("https://szcdn.ragalahari.com/april2018/hd/anchor-syamala-in-chudidar/", "anchor-syamala-in-chudidar,69");
		downloadFiles.put("https://szcdn.ragalahari.com/oct2017/starzone/anchor-shyamala-next-nuvve-audio/", "anchor-shyamala-next-nuvve-audio,56");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2016/hd/shyamala-red-saree/", "shyamala-red-saree,81");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2016/posters/shyamala-pink-posters/", "shyamala-pink-posters,69");
		downloadFiles.put("https://szcdn.ragalahari.com/sep2016/hd/shyamala-ragalahari-hd-stills/", "shyamala-ragalahari-hd-stills,58");
		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/starzone/syamala-in-gagra-choli/", "syamala-in-gagra-choli,55");
//		downloadFiles.put("https://szcdn.ragalahari.com/aug2016/starzone/shyamala-prajadairy/", "shyamala-prajadairy1025");
		downloadFiles.put("https://szcdn.ragalahari.com/june2016/starzone/syamala-jakkanna-audio-pics/", "syamala-jakkanna-audio-pics,38");
		downloadFiles.put("https://szcdn.ragalahari.com/jan2016/starzone/shyamala-in-pink-long-frock/", "shyamala-in-pink-long-frock,82");
		downloadFiles.put("https://szcdn.ragalahari.com/sept2015/starzone/shyamala-tease-18sep/", "shyamala-tease-18sep,35");
		downloadFiles.put("https://imgcdn.ragalahari.com/june2015/starzone/anchor-shyamala/", "anchor-shyamala,34");
		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/starzone/syamala-ramleela-audio/", "syamala-ramleela-audio,35");
		downloadFiles.put("https://imgcdn.ragalahari.com/jan2015/starzone/shyamala/", "shyamala,39");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2014/starzone/anchor-shyamala/", "anchor-shyamala,11");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2014/starzone/shyamala-chakkiligintha-audio/", "shyamala-chakkiligintha-audio,36");
		downloadFiles.put("https://szcdn.ragalahari.com/may2013/starzone/telugu-tv-anchor-syamala-in-saree/", "telugu-tv-anchor-syamala-in-saree,25");
		downloadFiles.put("https://szcdn.ragalahari.com/nov2012/starzone/shyamala-desire-curtain-raiser/", "shyamala-desire-curtain-raiser,50");
*/		
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/priya-vadlamani-mukhachitran-interview/", "priya-vadlamani-mukhachitran-interview,70");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/priya-vadlamani-mukhachitran-interview/", "priya-vadlamani-mukhachitran-interview,70");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/subhashree-rayaguru-katha-venuka-katha-first-look/", "subhashree-rayaguru-katha-venuka-katha-first-look,138");
//		downloadFiles.put("https://szcdn.ragalahari.com/dec2022/hd/srijitha-ghosh-katha-venuka-katha-first-look/", "srijitha-ghosh-katha-venuka-katha-first-look,109");
//		downloadFiles.put("https://szcdn.ragalahari.com/oct2022/hd/faria-abdullah-like-share-subscribe-prerelease/", "faria-abdullah-like-share-subscribe-prerelease,24");
//		downloadFiles.put("https://szcdn.ragalahari.com/feb2017/photosessions/avanthika_heroine-ragalahari/", "avanthika_heroine-ragalahari,115");
//		downloadFiles.put("https://szcdn.ragalahari.com/july2016/photosessions/avantika-hd-wallpapers/", "avantika-hd-wallpapers,200");
//		downloadFiles.put("https://szcdn.ragalahari.com/jan2021/hd/kamakshi-bhaskarla-sutraa-festive-special/", "kamakshi-bhaskarla-sutraa-festive-special,71");
//		downloadFiles.put("https://starzone.ragalahari.com/jun2024/hd/preethi-singh-latest-stills/", "preethi-singh-latest-stills,36");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2021/hd/sarayu-ravana-lanka-pre-release/", "sarayu-ravana-lanka-pre-release,57");
		
//		downloadFiles.put("https://starzone.ragalahari.com/jan2022/hd/nidhhi-agerwal-hero-thank-you-meet/", "nidhhi-agerwal-hero-thank-you-meet,43");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2023/hd/nidhi-agarwal-at-siima-pressmeet/", "nidhi-agarwal-at-siima-pressmeet,30");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2022/hd/nidhhi-agerwal-photoshoot-jan2022/", "nidhhi-agerwal-photoshoot-jan2022,33");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2022/hd/nidhhi-agerwal-hero-movie-press-meet/", "nidhhi-agerwal-hero-movie-press-meet,88");
//		downloadFiles.put("https://starzone.ragalahari.com/may2021/hd/niddhi-aggerwal-dark-green-hot-photoshoot/", "niddhi-aggerwal-dark-green-hot-photoshoot,40");
//		downloadFiles.put("https://starzone.ragalahari.com/may2021/hd/niddhi-agerwal-purble-dress-may2021/", "niddhi-agerwal-purble-dress-may2021,18");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/hd/niddhi-agarwal-barbie-doll-april2021/", "niddhi-agarwal-barbie-doll-april2021,40");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2020/hd/nidhhiagerwal-kakatiyafabrics-19teen-launch/", "nidhhiagerwal-kakatiyafabrics-19teen-launch,10");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2020/hd/nidhhi-agerwal-sutraa-expo-jan2020/", "nidhhi-agerwal-sutraa-expo-jan2020,68");

//		downloadFiles.put("https://starzone.ragalahari.com/jan2020/hd/nidhhi-agerwal-zee-cine-awards2020/", "nidhhi-agerwal-zee-cine-awards2020,30");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2020/hd/nidhhi-agerwal-manepally-disukhnagar/", "nidhhi-agerwal-manepally-disukhnagar,29");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2019/starzone/nidhhi-agerwal-photoshoot/", "nidhhi-agerwal-photoshoot5,11");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2019/hd/nidhhi-agerwal-ashok-galla-film-launch/", "nidhhi-agerwal-ashok-galla-film-launch,82");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2019/hd/nidhhi-agerwal-klm-patny-centre/", "nidhhi-agerwal-klm-patny-centre,63");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2019/hd/nidhhi-agerwal-bajaj-electronics/", "nidhhi-agerwal-bajaj-electronics,47");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2019/hd/niddhi-agerwal-siima2019/", "niddhi-agerwal-siima2019,28");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/hd/nidhhi-agerwal-the-chocolate-room/", "nidhhi-agerwal-the-chocolate-room,28");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/starzone/niddhi-agerwal-siima-2019/", "niddhi-agerwal-siima-2019,7");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/hd/niddhi-agerwal-sakshi-2018awards/", "niddhi-agerwal-sakshi-2018awards,24");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/hd/nidhhi-agerwal-ismartsuccess/", "nidhhi-agerwal-ismartsuccess,84");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/starzone/nidhhi-agerwal-ismart-success/", "nidhhi-agerwal-ismart-success,67");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/hd/nidhhi-agerwal-siima2019-pm/", "nidhhi-agerwal-siima2019-pm,64");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/posters/nidhhi-agerwal-ismartsuccess-interview1/", "nidhhi-agerwal-ismartsuccess-interview,51");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/starzone/nidhhi-agerwal-ismartshankar-vvit/", "nidhhi-agerwal-ismartshankar-vvit,27");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/posters/nidhhi-agerwal-ismart-shankar-pre/", "nidhhi-agerwal-ismart-shankar-pre,61");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/hd/nidhhi-agarwal-hi-life-expo-curtainraiser/", "nidhhi-agarwal-hi-life-expo-curtainraiser,46");
//		downloadFiles.put("https://starzone.ragalahari.com/june2019/hd/nidhhi-agarwal-arl-jeeto-shaan-se-hangama/", "nidhhi-agarwal-arl-jeeto-shaan-se-hangama,27");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/starzone/niddhi-agerwal-siima-2019/", "niddhi-agerwal-siima-2019,7");
//		downloadFiles.put("https://starzone.ragalahari.com/april2019/hd/nidhhi-agerwal-jito-youth-wing/", "nidhhi-agerwal-jito-youth-wing,33");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2019/hd/nidhhi-agerwal-peach-colr-photoshoot/", "nidhhi-agerwal-peach-colr-photoshoot,33");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2019/posters/nidhhi-agerwal-mr-majnu-interview/", "nidhhi-agerwal-mr-majnu-interview,56");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2019/posters/nidhhi-agerwal-mr-majnu-prerelease-pm/", "nidhhi-agerwal-mr-majnu-prerelease-pm,21");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2019/posters/nidhhi-agerwal-mr-majnu-prerelease/", "nidhhi-agerwal-mr-majnu-prerelease,39");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2018/hd/niddhiagerwal-savyasachi-prerelease/", "niddhiagerwal-savyasachi-prerelease,36");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2018/starzone/savyasachi-heroione-nidhi-agarwal/", "savyasachi-heroione-nidhi-agarwal,24");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/starzone/niddhi-agerwal-siima-2019/", "niddhi-agerwal-siima-2019,7");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/starzone/niddhi-agerwal-siima-2019/", "niddhi-agerwal-siima-2019,7");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2019/starzone/niddhi-agerwal-siima-2019/", "niddhi-agerwal-siima-2019,7");
//		
//		downloadFiles.put("https://starzone.ragalahari.com/oct2023/hd/eesha-rebba-at-mm-prerelease-event/", "eesha-rebba-at-mm-prerelease-event,39");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2023/hd/eesha-rebba-dayaa-prerelease-event/", "eesha-rebba-dayaa-prerelease-event,32");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2023/hd/eesha-rebba-interview-stills/", "eesha-rebba-interview-stills,47");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2022/hd/esha-rebba-jilebi-opening/", "esha-rebba-jilebi-opening,7");
//		downloadFiles.put("https://starzone.ragalahari.com/may2022/hd/eesha-rebba-shekar-trailer-launch/", "eesha-rebba-shekar-trailer-launch,28");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2023/hd/eesha-rebba-at-dayaa-trailer-launch/", "eesha-rebba-at-dayaa-trailer-launch,25");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2019/hd/eesha-rebba-hi-life-expo-dec719/", "eesha-rebba-hi-life-expo-dec719,101");
//		downloadFiles.put("https://starzone.ragalahari.com/may2022/hd/eesha-rebba-shekar-trailer-launch/", "eesha-rebba-shekar-trailer-launch,28");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2021/hd/eesha-rebba-ahas-3roses-success-meet/", "eesha-rebba-ahas-3roses-success-meet,22");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2020/hd/eesha-ebba-nov2020/", "eesha-ebba-nov2020,81");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/posters/eesha-rebba-siima2018/", "eesha-rebba-siima2018,47");
//		downloadFiles.put("https://starzone.ragalahari.com/june2019/posters/eesha-rebba-ragala24gantallo/", "eesha-rebba-ragala24gantallo,49");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2018/hd/eesha-rebba-chef-bakers-launch/", "eesha-rebba-chef-bakers-launch,47");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2018/posters/eesha-rebba-tartan-plazzo-pants/", "eesha-rebba-tartan-plazzo-pants,67");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2018/posters/eesha-rebba/", "eesha-rebba,47");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2018/starzone/eesharebba-aravindasametha-sm/", "eesharebba-aravindasametha-sm,28");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2018/starzone/eesharebba-aravindasametha-prerelease/", "eesharebba-aravindasametha-prerelease,11");
//		downloadFiles.put("https://starzone.ragalahari.com/july2018/starzone/eesha-rebba-photoshoot/", "eesha-rebba-photoshoot,17");
//		downloadFiles.put("https://starzone.ragalahari.com/july2018/starzone/eesha-rebba-saakshyam/", "eesha-rebba-saakshyam,1043");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2018/hd/eesha-rebba-santosham-awards/", "eesha-rebba-santosham-awards,59");
//		downloadFiles.put("https://starzone.ragalahari.com/july2018/starzone/eesha-rebba-saakshyam/", "eesha-rebba-saakshyam,43");
//		downloadFiles.put("https://starzone.ragalahari.com/june2018/starzone/eesha-rebba-yellow-dress/", "eesha-rebba-yellow-dress,16");
//		downloadFiles.put("https://starzone.ragalahari.com/june2018/hd/eesha-rebba-65th-jio-filmfare/", "eesha-rebba-65th-jio-filmfare,15");
//		downloadFiles.put("https://starzone.ragalahari.com/may2018/hd/eesha-rebba-heroine/", "eesha-rebba-heroine,31");
//		downloadFiles.put("https://starzone.ragalahari.com/april2018/posters/eesha-rebba-in-red-frock/", "eesha-rebba-in-red-frock,19");
//		downloadFiles.put("https://starzone.ragalahari.com/july2018/starzone/eesha-rebba-photoshoot/", "eesha-rebba-photoshoot,17");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2018/hd/eesha-rebba-santosham-awards/", "eesha-rebba-santosham-awards,59");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2018/hd/eesha-rebba-portfolio/", "eesha-rebba-portfolio,18");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2018/hd/eesha-subrahmanyapuram-muhurat/", "eesha-subrahmanyapuram-muhurat,29");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2018/hd/eesha-rebba-tshirt/", "eesha-rebba-tshirt,1008");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2018/starzone/eesha-rebba-awe/", "eesha-rebba-awe, 27");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2018/hd/eesha-rebba-awe-pre-release/", "eesha-rebba-awe-pre-release,49");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2017/posters/eesha-rebba-indian-dress/", "eesha-rebba-indian-dress,31");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2017/posters/eesha-rebba-mirchi-awards/", "eesha-rebba-mirchi-awards,22");
//		downloadFiles.put("https://starzone.ragalahari.com/july2017/posters/eesha-rebba-darshakudu-pre-release/", "eesha-rebba-darshakudu-pre-release,20");
//		downloadFiles.put("https://starzone.ragalahari.com/july2017/hd/eesha-rebba-darsakudu-heroine/", "eesha-rebba-darsakudu-heroine,37");
//		downloadFiles.put("https://starzone.ragalahari.com/july2017/hd/eesha-rebba-darsakudu/", "eesha-rebba-darsakudu,31");
//		downloadFiles.put("https://starzone.ragalahari.com/july2017/starzone/eesha-maaya-mall-pre-release/", "eesha-maaya-mall-pre-release,18");
//		downloadFiles.put("https://starzone.ragalahari.com/july2017/hd/eesha-rebba-darsakudu-audio/", "eesha-rebba-darsakudu-audio,42");
//		downloadFiles.put("https://starzone.ragalahari.com/june2017/posters/eesha-rabba-photos/", "eesha-rabba-photos,46");
//		downloadFiles.put("https://starzone.ragalahari.com/june2017/starzone/eesha-amitumi/", "eesha-amitumi,25");
//		downloadFiles.put("https://starzone.ragalahari.com/may2017/starzone/eesha-photos/", "eesha-photos,57");
//		downloadFiles.put("https://starzone.ragalahari.com/may2017/posters/eesha-darsakudu-teaser-launch/", "eesha-darsakudu-teaser-launch,50");
//		downloadFiles.put("https://starzone.ragalahari.com/may2016/starzone/eesha-gentleman-audio-release/", "eesha-gentleman-audio-release,80");

//		downloadFiles.put("https://imgcdn.ragalahari.com/feb2015/starzone/eesha-ramleela-audio/", "eesha-ramleela-audio,109");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2015/starzone/eesha-gaw/", "eesha-gaw,98");
//		downloadFiles.put("https://starzone.ragalahari.com/july2015/starzone/eesha-mirchi-awards/", "eesha-mirchi-awards,60");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2014/starzone/eesha-at-brotherofbommali-audio/", "eesha-at-brotherofbommali-audio,21");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2013/starzone/eesha-harisrinivas-art-exhibition/", "eesha-harisrinivas-art-exhibition,14");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2013/starzone/eesha-at-bajaj-electronics/", "eesha-at-bajaj-electronics,28");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2013/starzone/amat-heroine-eesha/", "amat-heroine-eesha,91");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2013/starzone/eesha-anthakamunduaataruvatha-successmeet/", "eesha-anthakamunduaataruvatha-successmeet,53");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2013/starzone/eesha-anthakamundu-aataruvatha-platinum/", "eesha-anthakamundu-aataruvatha-platinum,43");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2013/posters/anthakamundu-aataruvatha-eesha/", "anthakamundu-aataruvatha-eesha,89");
//		downloadFiles.put("https://starzone.ragalahari.com/april2013/starzone/eesha-anthakamundu-aatarvatha-pressmeet/", "eesha-anthakamundu-aatarvatha-pressmeet,16");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2012/photosessions/hyderabad-model-eesha-studio-shoot/", "hyderabad-model-eesha-studio-shoot,266");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2012/photosessions/eesha-western-dress-shoot/", "eesha-western-dress-shoot,61");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2011/starzone/eesha-gray-color-ragalahari-ps/", "eesha-gray-color-ragalahari-ps,149");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2011/starzone/eesha-blue-dress-ragalahari-ps/", "eesha-blue-dress-ragalahari-ps,174");
//		downloadFiles.put("https://starzone.ragalahari.com/july2011/starzone/eesha-red-dress-ragalahari-ps/", "eesha-red-dress-ragalahari-ps,110");
//		downloadFiles.put("https://starzone.ragalahari.com/july2011/starzone/easha-orange-saree-ragalahari-ps/", "easha-orange-saree-ragalahari-ps,148");
//		downloadFiles.put("https://starzone.ragalahari.com/april2011/starzone/hyderabad-model-eesha-high-resolution/", "hyderabad-model-eesha-high-resolution,80");
//		downloadFiles.put("https://starzone.ragalahari.com/apr2024/hd/amiksha-latest-hd-stills/", "amiksha-latest-hd-stills,44");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2017/posters/priyanka-augustin-heroine/", "priyanka-augustin-heroine,57");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2023/hd/meenakshi-chaudhary-at-siima/", "meenakshi-chaudhary-at-siima,45");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2022/hd/meenakshi-choudharu-khiladi-pre-release/", "meenakshi-choudharu-khiladi-pre-release,55");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2022/hd/meenakshi-chowdary-khiladi-interview/", "meenakshi-chowdary-khiladi-interview,100");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2022/hd/meenakshi-chaudary-photoshoot-feb2022/", "meenakshi-chaudary-photoshoot-feb2022,47");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2021/hd/meenakshi-choudhary-ivnr-pre-release/", "meenakshi-choudhary-ivnr-pre-release,25");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2020/hd/meenakshi-chowdhary-ichata-vnr-opening/", "meenakshi-chowdhary-ichata-vnr-opening,28");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2023/hd/meenakshi-at-hatya-pre-release-event/", "meenakshi-at-hatya-pre-release-event,23");
//		downloadFiles = buildMap("https://starzone.ragalahari.com/mar2023/hd/meenakshi-at-vishwak-new-movie-launch/meenakshi-at-vishwak-new-movie-launch26t.jpg");
//		downloadFiles = buildMap("https://starzone.ragalahari.com/nov2022/hd/meenakshi-chowdary-hit2-pre-release-event/meenakshi-chowdary-hit2-pre-release-event29t.jpg");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2022/hd/meenakshi-chowdary-hit2-pre-release-event/", "meenakshi-chowdary-hit2-pre-release-event,29");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2022/hd/meenakshi-chaudary-hit2-teaser-launch/", "meenakshi-chaudary-hit2-teaser-launch,21");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2022/hd/dimple-hayathi-photoshoot-feb2022/", "dimple-hayathi-photoshoot-feb2022,17");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2024/hd/dimple-hayathi-at-gaama-awards-event/", "dimple-hayathi-at-gaama-awards-event,24");
//		downloadFiles.put("https://starzone.ragalahari.com/apr2023/hd/dimple-at-ramabanam-interview/", "dimple-at-ramabanam-interview,38");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2022/hd/dimple-hayathi-khiladi-pre-release/", "dimple-hayathi-khiladi-pre-release,47");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2022/hd/dimple-hyati-khiladi-movie-interview/", "dimple-hyati-khiladi-movie-interview,99");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2023/hd/alekhya-new-stills/", "alekhya-new-stills,46");
//		downloadFiles.put("https://starzone.ragalahari.com/may2024/hd/actress-simrithi-gold-shinedress/", "actress-simrithi-gold-shinedress,50");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2023/hd/madhumita-latest-stills-aug/", "madhumita-latest-stills-aug,90");
//		downloadFiles.put("https://starzone.ragalahari.com/sep2023/hd/anusri-at-rr-creations-movie-launch/", "anusri-at-rr-creations-movie-launch,39");
//		downloadFiles.put("https://starzone.ragalahari.com/july2016/starzone/alekhya-blue-saree/", "alekhya-blue-saree,47");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2023/hd/sudiksha-latest-stills/", "sudiksha-latest-stills,18");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2023/hd/moksha-at-neetho-nenu-teaser-launch/", "moksha-at-neetho-nenu-teaser-launch,36");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2023/hd/kavya-ramesh-at-nachinavadu-event/", "kavya-ramesh-at-nachinavadu-event,32");
//		downloadFiles.put("https://starzone.ragalahari.com/jun2023/hd/payal-guptha-stills/", "payal-guptha-stills,24");
//		downloadFiles.put("https://starzone.ragalahari.com/jun2023/hd/ananya-at-aaak-trailer-launch/", "ananya-at-aaak-trailer-launch,41");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2011/starzone/nakantu-okkaru-heroine-akshaya/", "nakantu-okkaru-heroine-akshaya,22");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2012/starzone/srividya-new-film-muhurat/", "srividya-new-film-muhurat,50");
//		downloadFiles.put("https://starzone.ragalahari.com/sept2013/photosessions/srividya-halfsaree-photoshoot/", "srividya-halfsaree-photoshoot,200");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2013/starzone/adhee-lekka-heroine-srividya/", "adhee-lekka-heroine-srividya,79");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2013/posters/srividya-hot-saree-photos/", "srividya-hot-saree-photos,81");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2013/starzone/srividya-at-tumeda-audio-release/", "srividya-at-tumeda-audio-release,38");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2014/starzone/heroine-srividya/", "heroine-srividya,32");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/srividya-in-black-frock/", "srividya-in-black-frock,114");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/srividya-in-western-wear/", "srividya-in-western-wear,69");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/srividya-in-salwar/", "srividya-in-salwar,114");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2016/photosessions/srividya-in-sexy-frock/", "srividya-in-sexy-frock,126");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2024/hd/rakul-preet-singh-at-indian2-pressmeet/", "rakul-preet-singh-at-indian2-pressmeet,46");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2024/hd/digangana-at-shivam-bhaje-trailer-launch/", "digangana-at-shivam-bhaje-trailer-launch,43");
//		downloadFiles.put("https://starzone.ragalahari.com/june2019/posters/digangana-suryavanshi-hippi-interview/", "digangana-suryavanshi-hippi-interview,123");
//		downloadFiles.put("https://starzone.ragalahari.com/jun2024/hd/laya-rao-sutraa-exhibition/", "laya-rao-sutraa-exhibition,44");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2019/starzone/dhanya-balakrishna-software-sudhir-pm/", "dhanya-balakrishna-software-sudhir-pm,57");
//		downloadFiles.put("https://starzone.ragalahari.com/july2022/hd/dhanya-balakrishna-xappie-studio-launch/", "dhanya-balakrishna-xappie-studio-launch,35");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2020/hd/dhanya-balakrishna-aoao-pm/", "dhanya-balakrishna-aoao-pm,72");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2020/hd/dhanya-balakrishna-hulchul-pre-release/", "dhanya-balakrishna-hulchul-pre-release,32");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2024/hd/anjali-at-bahishkarana-successmeet/", "anjali-at-bahishkarana-successmeet,50");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2010/starzone/anjali-high-resolution/", "anjali-high-resolution,87");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2011/starzone/anjali-highres-journey-audio-release/", "anjali-highres-journey-audio-release,42");
//		downloadFiles.put("https://starzone.ragalahari.com/july2013/posters/anjali-at-balupu-successmeet/", "anjali-at-balupu-successmeet,118");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2013/hd/tamil-actress-anjali-in-saree/", "tamil-actress-anjali-in-saree,208");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2014/hd/anjali-in-madha-gaja-raja/", "anjali-in-madha-gaja-raja,123");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2014/hd/anjali-in-vathikuchi-stills/", "anjali-in-vathikuchi-stills,56");
//		downloadFiles.put("https://starzone.ragalahari.com/may2014/hd/heroine-anjali-in-svsc/", "heroine-anjali-in-svsc,373");
//		downloadFiles.put("https://starzone.ragalahari.com/june2014/starzone/tamil-heroine-anjali/", "tamil-heroine-anjali,27");
//		downloadFiles.put("https://starzone.ragalahari.com/aug2014/starzone/anjali-geetanjali-sucessmeet/", "anjali-geetanjali-sucessmeet,284");
//		downloadFiles.put("https://starzone.ragalahari.com/july2014/starzone/anjali-pink/", "anjali-pink,13");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2013/starzone/anjali-at-pranam-kosam-audio/", "anjali-at-pranam-kosam-audio,147");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2013/starzone/anjali-preminchali-audio/", "anjali-preminchali-audio,82");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2013/hd/balupu-anjali-in-salwar/", "balupu-anjali-in-salwar,59");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2013/starzone/anjali-redfm-7th-anniversary-lucky-draw/", "anjali-redfm-7th-anniversary-lucky-draw,42");
//		downloadFiles.put("https://starzone.ragalahari.com/nov2013/posters/anjali-at-masala-audio-success-meet/", "anjali-at-masala-audio-success-meet,69");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2013/hd/tamil-actress-anjali-in-saree/", "tamil-actress-anjali-in-saree,208");
//		downloadFiles.put("https://starzone.ragalahari.com/july2013/posters/anjali-at-balupu-successmeet/", "anjali-at-balupu-successmeet,118");
//		downloadFiles.put("https://starzone.ragalahari.com/june2013/hd/anjali-balupu-audio/", "anjali-balupu-audio,68");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2015/hd/anjali-telugu-heroine-hot-images/", "anjali-telugu-heroine-hot-images,184");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2015/hd/anjali-chitrangada-hd/", "anjali-chitrangada-hd,509");
//		downloadFiles.put("https://starzone.ragalahari.com/oct2015/starzone/anjali-sankarabharanam-audio/", "anjali-sankarabharanam-audio,46");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2016/posters/anjali-dictator-heroine/", "anjali-dictator-heroine,127");
//		downloadFiles.put("https://starzone.ragalahari.com/july2012/starzone/anjali-sathi-leelavathi-audio-release/", "anjali-sathi-leelavathi-audio-release,15");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2016/hd/anjali-sankranthi-rangoli/", "anjali-sankranthi-rangoli,68");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2016/hd/anjali-dictator-interview/", "anjali-dictator-interview,138");
//		downloadFiles.put("https://starzone.ragalahari.com/april2016/hd/anjali-madha-gaja-raja/", "anjali-madha-gaja-raja,7");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2017/posters/anjali-chitrangada-pre-release/", "anjali-chitrangada-pre-release,80");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2017/posters/anjali-chitrangadha-success-meet/", "anjali-chitrangadha-success-meet,77");
//		downloadFiles.put("https://starzone.ragalahari.com/may2019/posters/anjali-lissa-pre-release/", "anjali-lissa-pre-release,79");
//		downloadFiles.put("https://starzone.ragalahari.com/july2019/posters/anjali-siima2018/", "anjali-siima2018,19");
//		downloadFiles.put("https://starzone.ragalahari.com/mar2020/hd/anjali-nishabdham-pre-release/", "anjali-nishabdham-pre-release,28");
//		downloadFiles.put("https://starzone.ragalahari.com/jan2021/hd/anjali-fortune-99-home-branch-office/", "anjali-fortune-99-home-branch-office,30");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/hd/anjali-vakeel-saab-interview/", "anjali-vakeel-saab-interview,94");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/starzone/anjali-vakeel-saab-pre-release/", "anjali-vakeel-saab-pre-release,117");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/hd/anjali-maguva-nee-vijayam-event/", "anjali-maguva-nee-vijayam-event,112");
//		downloadFiles.put("https://starzone.ragalahari.com/april2021/hd/anjali-vakeel-saab-ugadi-special-interview/", "anjali-vakeel-saab-ugadi-special-interview,49");
//		downloadFiles.put("https://starzone.ragalahari.com/dec2021/hd/anjali-disney-plus-press-meet/", "anjali-disney-plus-press-meet,46");
//		downloadFiles.put("https://starzone.ragalahari.com/july2022/hd/anjali-macherla-niyojakavargam-song-launch/", "anjali-macherla-niyojakavargam-song-launch,36");
//		downloadFiles.put("https://starzone.ragalahari.com/feb2024/hd/anjali-at-geetanjali-malli-vachindi-event/", "anjali-at-geetanjali-malli-vachindi-event,34");
//		downloadFiles.put("https://starzone.ragalahari.com/apr2024/hd/anjalli-at-gmv-trailer-launch/", "anjalli-at-gmv-trailer-launch,39");
//		downloadFiles.put("https://starzone.ragalahari.com/apr2024/hd/anjali-at-gmv-movie-interview/", "anjali-at-gmv-movie-interview,42");
//		downloadFiles.put("https://starzone.ragalahari.com/apr2024/hd/heroine-anjali-at-gmv-pre-release/", "heroine-anjali-at-gmv-pre-release,35");
//		downloadFiles.put("https://starzone.ragalahari.com/apr2024/hd/anjali-at-gog-teaser-launch-event/", "anjali-at-gog-teaser-launch-event,29");
//		downloadFiles.put("https://starzone.ragalahari.com/may2024/hd/anjali-gangs-of-godavari-interview/", "anjali-gangs-of-godavari-interview,59");
//		downloadFiles.put("https://starzone.ragalahari.com/jul2024/hd/anjali-at-bahishkarana-successmeet/","anjali-at-bahishkarana-successmeet,50");
//		downloadFiles.put("");
//		downloadFiles.put("");
//		
		
		for (String key : downloadFiles.keySet()) {
			String values[] = downloadFiles.get(key).split(",");
			if(values.length  >  1) {
			System.out.println("Length " + values.length);
			String folderName = values[0];
			System.out.println(folderName);
			
			String maxPics = values[1];
			System.out.println(maxPics);
			File file = new File("c:/wallpapers2/shyamala/" + folderName);
			if (!file.exists()) {
				file.mkdirs();
			}
			for (int i = 1; i <= Integer.parseInt(maxPics); i++) {			
					String fileName = folderName + i + ".jpg";
					String fromFile = key + fileName;
					String toFile = file.toString() + "/" + fileName;	
					File tof = new File(toFile);
					if(tof.exists()) {
						continue;
					}
					try {	
						TheKing_DownloadFileFromURL(fromFile, toFile, fileName);
					} catch (IOException e) {
						System.out.println(fromFile);
//						 e.printStackTrace();
						continue;	
					}
				}
			}
		}
		System.out.println("Completed !!!");		
	}
	
	
	private static Map<String, String> buildMap(String str){
		if(str.trim().length() == 0) {
			return null;
		}
		int lastIndex =  str.lastIndexOf("/");		
		String first = str.substring(0, lastIndex).concat("/");
		String second = str.substring(lastIndex+1);
		int thridInd = second.lastIndexOf("t.jpg");
		String third = second.substring(0, thridInd);
		String fourth = third.replaceAll("[^0-9]", "");
		String fith = third.replace(fourth, "");
		Map<String, String> result = new HashMap<>();
		result.put(first, fith+"," + fourth);
		return result;
	}
}