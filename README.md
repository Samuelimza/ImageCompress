# ImageCompress

This is a project implementing lossy image compression using the [K Means Clustering](https://en.wikipedia.org/wiki/K-means_clustering) Machine learning algorithm

## Install the dependencies
Firstly clone the repo. Double-click install.sh to install all the required dependencies.

## To Use
Usable for a .png image.

### For Compression
Follow the following steps:
1. Rename your image to 'Compress.png'.
2. Get your image directry path by right clicking->Properties->Location. Copy it.
3. Run the Run.jar.
4. Paste the path in the first field and press compress (Wait 10 seconds).
You should now have two new files alongside the image namely codebook.npy and compressed.png.
These files are the compressed form of your image.

### For Decompression
Follow the following steps:
1. Get the directry path of your codebook.npy and compressed.png files as previously mentioned.
2. Run the Run.jar.
3. Paste the path in the second field and press decompress.
You should now have a new file in the directry as compressed1.png.
This is the lossy decompressed version of your original image.
