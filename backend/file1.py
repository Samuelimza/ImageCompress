import numpy as np
import cv2
f=open('backend/path.txt','r')
path=f.read()
img=cv2.imread(path+'\compressed.png',0)
centroids_index=np.array(img)
a,b=np.shape(centroids_index)
centroids_index=np.reshape(centroids_index,[a*b,1],2)
centroids=np.load(path+'\codebook.npy')
m=a*b
X_pix=np.zeros((m,3))
for i in range(0,m):
    X_pix[i,:]=centroids[centroids_index[i,0],:]
X_pix=np.reshape(X_pix,[a,b,3],3)
cv2.imwrite(path+'\compressed1.png',X_pix)
