public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }
    public long getCompressionRatio(){
        long result= 100-((compressedSize * 100) / size);
        return result;
    }

    @Override
    public String toString() {
        String s=null;
        if(size>0){
            s=String.format("%s %d Kb (%d Kb) сжатие: %d%%",name,size/1024,compressedSize/1024,getCompressionRatio());
        } else s=name;
        return s;
    }

    public String getName() {
        return name;
    }
    public long getSize() {
        return size;
    }
    public long getCompressedSize() {
        return compressedSize;
    }
    public int getCompressionMethod() {
        return compressionMethod;
    }
}
