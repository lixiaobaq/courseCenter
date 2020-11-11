package com.iothings.util;

import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.iothings.enums.ResultEnum;
import com.iothings.exception.UnsupportedFileTypeException;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;
/**
 * @Package： com.iothings.util
 * @author： ZDL
 * @date： 2020/11/9 13:29
 * @version： V1.0
 * @Description：
 */
public class FileUtils {
    public static final String FILE_IMAGE = "img";
    public static final String FILE_VIDEO = "video";
    public static final String FILE_DOC = "doc";
    public static final String FILE_OTHER = "other";
    private static final String propertyFilename = "/upload.properties";
    private static final String splitRegex = "\\|";

    /**
     * 判断是否是图片文件
     *
     * @param filename
     * @return
     * @deprecated 已过时,用getFileType代替
     */
    @Deprecated
    public static final boolean isImage(String filename) {
        if (filename == null || filename.length() <= 0) {
            return false;
        } else {
            try {
                String fileExt = getFileExt(filename);
                if (fileExt.equals("jpg") || fileExt.equals("png") || fileExt.equals("bmp")) {
                    return true;
                } else {
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }
    }

    /**
     * 获取上传文件类型方法,根据上传的文件名后缀和上传配置文件配置的surfix类型,判断该文件的类型
     *
     * @param filename
     *            文件名
     * @return 返回文件类型
     * @throws IOException
     *             如果上传配置文件读取错误
     * @throws PropertyException
     *             如果上传配置文件配置错误
     */
    public static String getFileType(String filename) throws IOException, PropertyException {
        if (filename == null || filename.length() <= 0) {
            return FILE_OTHER;
        } else {
            String fileExt = getFileExt(filename);
            String[] allowedImageFileExt = PropUtil.getProperty(propertyFilename, "allowedImageFileExt").split(splitRegex);
            String[] allowedDocFileExt = PropUtil.getProperty(propertyFilename, "allowedDocFileExt").split(splitRegex);
            String[] allowedVideoFileExt = PropUtil.getProperty(propertyFilename, "allowedVideoFileExt").split(splitRegex);
            for (String ext : allowedImageFileExt) {
                if (fileExt.equals(ext)) {
                    return FILE_IMAGE;
                }
            }

            for (String ext : allowedDocFileExt) {
                if (fileExt.equals(ext)) {
                    return FILE_DOC;
                }
            }

            for (String ext : allowedVideoFileExt) {
                if (fileExt.equals(ext)) {
                    return FILE_VIDEO;
                }
            }
            return FILE_OTHER;
        }
    }

    /**
     * 保存MultipartFile 对象中的文件到配置文件指定的服务器路径并返回重新生成的文件名
     *
     * @param file
     *            multipart类型对象
     * @return 保存到服务器的文件名
     * @throws IOException
     *             读取配置文件失败时
     * @throws PropertyException
     *             配置项有误时
     * @throws UnsupportedFileTypeException
     *             上传不支持的文件格式时
     */
    public static String saveFile(MultipartFile file) throws IOException, PropertyException, UnsupportedFileTypeException {

        String relName = file.getOriginalFilename();
        String fileExt = getFileExt(relName);
        if (!isAllowedFileType(fileExt)) {
            throw new UnsupportedFileTypeException(ResultEnum.UPLOAD_ERROR);
        }
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName = getFileType(relName) + fmt.format(new Date()) + Math.round(Math.random() * 9000) + "." + fileExt;
        // System.out.println(path);
        File targetFile = new File(getUploadPath(), fileName);
        if (!targetFile.exists()) {
            // targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        return FileUtils.getRelativePath() + fileName;
    }

    /**
     * 保存MultipartFile 对象中的文件到配置文件指定的服务器路径并返回重新生成的文件名
     *
     * @param file
     *            multipart类型对象
     * @return 保存到服务器的文件名
     * @throws IOException
     *             读取配置文件失败时
     * @throws PropertyException
     *             配置项有误时
     * @throws UnsupportedFileTypeException
     *             上传不支持的文件格式时
     */
    public static String appSaveFile(MultipartFile file, String index) throws IOException, PropertyException, UnsupportedFileTypeException {

        String relName = file.getOriginalFilename();
        String fileExt = getFileExt(relName);
        if (!isAllowedFileType(fileExt)) {
            throw new UnsupportedFileTypeException(ResultEnum.UPLOAD_ERROR);
        }
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName = getFileType(relName) + fmt.format(new Date()) + Math.round(Math.random() * 9000) + "." + fileExt;
        // System.out.println(path);
        File targetFile = new File(getUploadPath(index), fileName);//
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        return FileUtils.getHeadRelativePath(index) + fileName;
    }

    /**
     * 根据相对路径,删除服务器文件夹里的文件.
     *
     * @param relativeFileName
     *            文件名,相对路径
     * @return 如果删除成功,返回 true,文件无法找到或者文件名解析错误或者发生异常返回false
     */
    public static boolean deleteFile(String relativeFileName) {
        try {
            String[] fileStrs = relativeFileName.split("/");
            String fileName = fileStrs[fileStrs.length - 1];
            if (null == fileName || fileName.equals("")) {
                return false;
            } else {
                File targetFile = new File(getUploadPath(), fileName);
                if (targetFile.exists()) {
                    return targetFile.delete();
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断文件类型是否为允许的类型,文件类型白名单通过upload.properties的 isAllowedFileType配置项进行配置
     *
     * @param fileExt
     *            文件后缀名
     * @return 如果文件类型允许,则返回true,如果文件类型不合法,返回false.
     * @throws IOException
     *             配置文件<code>upload.properties</code>读取错误时
     * @throws PropertyException
     *             配置项错误时
     */
    public static boolean isAllowedFileType(String fileExt) throws IOException, PropertyException {
        String[] allowedFileExt = PropUtil.getProperty(propertyFilename, "allowedFileExt").split(splitRegex);
        for (String ext : allowedFileExt) {
            if (fileExt.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回配置文件中的文件上传路径
     *
     * @return 保存文件的绝对路径
     * @throws IOException
     *             如果无法读取到配置文件
     * @throws PropertyException
     * @throws PropertyException
     */
    private static String getUploadPath() throws IOException, PropertyException {
        String absolutePath = "";
        absolutePath = PropUtil.getProperty(propertyFilename, "absolutePath");
        // String absolutePath = props.getProperty("relativePath"); //代表是相对路径
        return absolutePath;
    }

    /**
     * 返回配置文件中的文件上传路径
     *
     * @return 保存文件的绝对路径
     * @throws IOException
     *             如果无法读取到配置文件
     * @throws PropertyException
     * @throws PropertyException
     */
    private static String getUploadPath(String index) throws IOException, PropertyException {
        String absolutePath = "";

        /*
         * if(index.equals(ImageFileType.HEAD)){
         * absolutePath=PropUtil.getProperty(propertyFilename, "headPath");
         * }else if(index.equals(ImageFileType.CARD)){
         * absolutePath=PropUtil.getProperty(propertyFilename, "cardPath");
         * }else if(index.equals(ImageFileType.FAQ)){
         * absolutePath=PropUtil.getProperty(propertyFilename, "faqPath"); }else
         * if(index.equals(ImageFileType.LOAN)){
         * absolutePath=PropUtil.getProperty(propertyFilename, "loanPath"); }
         */

        // String absolutePath = props.getProperty("relativePath"); //代表是相对路径
        return absolutePath;
    }

    /**
     * 返回配置文件中的资源文件夹web相对路径
     *
     * @return 相对路径 例, /upload/img144564656546.jpg
     * @throws PropertyException
     * @throws IOException
     */
    public static String getRelativePath() throws PropertyException, IOException {
        String relativePath = "";
        relativePath = PropUtil.getProperty(propertyFilename, "relativePath");
        // String absolutePath = props.getProperty("relativePath"); //代表是相对路径
        return relativePath;
    }

    /**
     * 返回配置文件中的图片模块化管理资源文件夹web相对路径
     *
     * @return 相对路径 例, /upload/img144564656546.jpg
     * @throws PropertyException
     * @throws IOException
     */
    public static String getHeadRelativePath(String index) throws PropertyException, IOException {
        String relativePath = "";
        /*
         * if(index.equals(ImageFileType.HEAD)){
         * relativePath=PropUtil.getProperty(propertyFilename,
         * "relativeHeadPath"); }else if(index.equals(ImageFileType.CARD)){
         * relativePath=PropUtil.getProperty(propertyFilename,
         * "relativeCardPath"); }else if(index.equals(ImageFileType.FAQ)){
         * relativePath=PropUtil.getProperty(propertyFilename,
         * "relativefaqPath"); }else if(index.equals(ImageFileType.LOAN)){
         * relativePath=PropUtil.getProperty(propertyFilename,
         * "relativeLoanPath"); }
         */
        return relativePath;
    }

    /**
     * 获取文件后缀名方法
     *
     * @param filename
     *            原始文件名
     * @return 返回.后面的文件后缀名
     */
    private static String getFileExt(String filename) {
        String fileExt = filename.substring(filename.lastIndexOf(".") + 1, filename.length()).toLowerCase();
        return fileExt;
    }

    public static void copyFile(File uploadify, File savefile) {
        // TODO Auto-generated method stub

    }

    /**
     * 用Thumbnailator处理图片类 进行图片压缩   uploadFileAndCreateThumbnail(file,false,"800","800",false,"1")
     * @param file  multipart类型对象
     * @param isCompress  是否压缩  优先级2高
     * @param width 压缩后宽度
     * @param height 压缩后高度
     * @param isReplace  是否替换掉原图  优先级3高
     * @param fileSize  超过设定值压缩  单位是M 优先级1高    空则只上传
     * @author ZDL
     * @throws IOException
     * @throws PropertyException
     */
    public static String uploadFileAndCreateThumbnail(MultipartFile file,boolean isCompress,String width,String height,boolean isReplace,String fileSize) throws PropertyException, IOException {

        String thumbnailPathName = file.getOriginalFilename();
        String fileExt = getFileExt(thumbnailPathName);
        String thumbnailFilePathName = ""; //图片名称，用于输出
        try {
            if (!isAllowedFileType(fileExt)) {
                throw new UnsupportedFileTypeException(ResultEnum.UPLOAD_ERROR);
            }
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String fileName = getFileType(thumbnailPathName) + fmt.format(new Date()) + Math.round(Math.random() * 9000) + "." + fileExt;
            File targetFile = new File(getUploadPath(), fileName);
            if (!targetFile.exists()) {
                // targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            long size = targetFile.length();
            double scale = 1.0d;
            int fSize = fileSize!=""?Integer.parseInt(fileSize):5 ;
            if (size >= fSize * 1024) {
                scale = (fSize * 1024f) / size;
                System.out.println(scale);
            }
            if("" != fileSize && size > fSize*1024*1024){
                if (isCompress) {
                    if(isReplace){
                        thumbnailFilePathName = fileName.substring(0, fileName.lastIndexOf(".")) + "_new."+fileExt;
                    }else{
                        thumbnailFilePathName = fileName.substring(0, fileName.lastIndexOf(".")) + "."+fileExt;
                    }
                    // 变为width*height,遵循原图比例缩或放到width*某个高度
                    Thumbnails.of(FileUtils.getUploadPath()+fileName).size(width!=""?Integer.parseInt(width):400, height!=""?Integer.parseInt(height):400).toFile(FileUtils.getUploadPath()+thumbnailFilePathName);
                } else {
                    if(isReplace){
                        thumbnailFilePathName = fileName.substring(0, fileName.lastIndexOf(".")) + "_new."+fileExt;
                    }else{
                        thumbnailFilePathName = (fileName).substring(0, fileName.lastIndexOf(".")) + "."+fileExt;
                    }
                    // 图片尺寸不变，压缩图片文件大小outputQuality实现,参数1为最高质量
                    Thumbnails.of(FileUtils.getUploadPath()+fileName).scale(1f).outputQuality(scale).outputFormat(fileExt).toFile(FileUtils.getUploadPath()+thumbnailFilePathName);
                }
            }else{
                thumbnailFilePathName = fileName;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return FileUtils.getRelativePath() + thumbnailFilePathName;
    }
}
