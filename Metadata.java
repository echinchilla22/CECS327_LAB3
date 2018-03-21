package LAB3;

class Chunk//Page
{
        Long guid;
        Long length;//size
}

class MetaFile
{
        String name;
        Long  length;
        List<Chunk> chunks;

        public String getName(){
          return name;
        }

        public void setName(String name){
          this.name = name;
        }

        public String getLength(){
          return length;
        }

        public void setLength(Long length){
          this.length = length;
        }

        public List<Chunk> getChunkList(){
          return chunks;
        }

        public void addChunk(Chunk c){
          this.chunks.add(c);
        }
        public JsonArray createJsonChunks(){
              for each c in chunks
                 c.createJson();
        }
}

class Metadata
{
      List<MetaFile>  metafiles;
      JsonObject toJsonObject;    // Create a Json Object that contains the file
      void readFromJsonObject(JsonObject m);  // Read from a Json Object that contains the files
      JsonArray array = Json.createArrayBuilder().build();


      public void createJson(MetaFile file){
        this.toJsonObject = Json.createObjectBuilder().build();

        for(int i= 0; i < metafiles.size(); i++){
          file = metafiles.get(i);
          JsonObject j = createJson(file.createJsonChunks());


    //      LAB3.Chunk tempChunk;
        //  for(int j = 0; j < tempFile.getChunkList().size(); j++){
        ////    tempChunk = tempFile.getChunkList().get(j);

          }
        }
        toJsonObject.put("metadata", metafiles);

      }

      public void addFile(String name, Long length){
        MetaFile metafile = new MetaFile();
        metafile.setName(name);
        metafile.setLength(length);
        this.metafiles.add(metafile);

      }

      public void addChunkToFile(Chunk chunk, String fileName){
        for(int i = 0; i < metafiles.size(); i++){
          if(metafiles.get(i).getName().equals(fileName)){
            metafiles.get(i).addChunk(chunk);
          }
        }
      }
}
