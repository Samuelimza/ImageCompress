from skimage import io
from sklearn.cluster import KMeans
import numpy as np
image = io.imread('bird_small.png')
io.imshow(image)
io.show()
rows = image.shape[0]
cols = image.shape[1]
image = image.reshape(image.shape[0] * image.shape[1], 3)
kmeans = KMeans(n_clusters=128, n_init=10, max_iter=200)
kmeans.fit(image)
clusters=np.array(kmeans.cluster_centers_,dtype=np.uint8)
labels=np.array(kmeans.labels_,dtype=np.uint8)
print(labels)
labels=labels.reshape(rows, cols)
print(labels)
np.save('codebook.npy', clusters)
io.imsave('compressed.png',labels)
