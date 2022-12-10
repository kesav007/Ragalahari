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
		
		for (String key : downloadFiles.keySet()) {
			File file = new File("c:/wallpapers/teja/" + downloadFiles.get(key));
			if (!file.exists()) {
				file.mkdirs();
			}
			for (int i = 1; i < 250; i++) {			
					String fileName = downloadFiles.get(key) + i + ".jpg";
					String fromFile = key + fileName;
					String toFile = file.toString() + "/" + fileName;	
					File tof = new File(toFile);
					if(tof.exists()) {
						continue;
					}
					try {	
						TheKing_DownloadFileFromURL(fromFile, toFile, fileName);
					} catch (IOException e) {
						 e.printStackTrace();
						continue;	
					}
			}
		}
		System.out.println("Completed !!!");		
	}
}