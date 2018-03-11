# ImageCompress

This is a project implementing lossy image compression using A machine learning algorithm (K Means)

To run it on an image (.png) follow the following steps:
1. Rename your image to 'Compress.png'.
2. Get your image directry path by right clicking->Properties->Location. Copy it.
3. Run the Run.jar.
4. Paste the path in the first field and press compress (Wait 10 seconds).
5. You should now have two new files alongside the image namely codebook.npy and compressed.png.
6. These files are the compressed form of your image.

To decompress the files follow:
1. Get the directry path of your codebook.npy and compressed.png files as previously mentioned.
2. Run the Run.jar.
3. Paste the path in the second field and press decompress.
4. You should now have a new file in the directry as compressed1.png.
5. This is the lossy decompressed version of your original image.
