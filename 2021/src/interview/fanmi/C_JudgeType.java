package interview.fanmi;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/25 13:56
 **/

public class C_JudgeType {
    /**
     * 获取文件扩展名，不带 .
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return getFileType(filename.substring(dot + 1));
            }
        }
        return getFileType(filename);
    }

    /**
     * 功能描述: 校验文件名后缀
     *
     * @param type 待校验类型
     * @return 确定类型
     * @author jiaoqianjin
     * @date 2021/12/25
     */
    public static String getFileType(String type) {
        String documents = "txt doc pdf ppt pps xlsx xls docx";
        String audio = "mp3 wav wma mpa ram ra aac aif m4a";
        String video = "avi mpg mpe mpeg asf wmv mov qt rm mp4 flv m4v webm ogv ogg";
        String image = "bmp dib pcp dif wmf gif jpg tif eps psd cdr iff tga pcd mpt png jpeg";
        String forbid = "exe sql js php";
        if (image.contains(type)) {
            return "验证通过，文件类型为：图片";
        } else if (documents.contains(type)) {
            return "验证通过，文件类型为：文档";
        } else if (audio.contains(type)) {
            return "验证通过，文件类型为：音乐";
        } else if (video.contains(type)) {
            return "验证通过，文件类型为：视频";
        } else if (forbid.contains(type)) {
            return "验证失败，文件类型禁止上传";
        } else {
            return "验证失败，文件类型为其他";
        }
    }

    public static void main(String[] args) {
        String fileName = "test.sql";
        System.out.println(getExtensionName(fileName));
    }
}
