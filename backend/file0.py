import numpy as np
import tensorflow as tf
import random
import cv2


#loading the required data
f=open('backend/path.txt','r')
path=f.read()
path0=path+'\Compress.png'
img=cv2.imread(path0,1)
X=np.array(img)


a,b,c=np.shape(X)
X=np.reshape(X,[a*b,c],2)
m,n=np.shape(X)
K=255    #the number of clusters to be formed
max_iter=200  #maximum number of iterations to be performed

#randomly initializing the centroids
centroids=np.zeros((K,n),np.float32)
for i in range(0,K):
    w=random.randint(0,m)
    centroids[i,:]=X[w,:]

#initializing the required tensorflow tensors

X=tf.constant(X,tf.float32)
centroids=tf.Variable(centroids,tf.float32)
init=tf.global_variables_initializer()
sess=tf.Session()
sess.run(init)


#forming clusters
centroids_mat=tf.reshape(tf.tile(centroids,[m,1]),[m,K,n])
X_mat=tf.reshape(tf.tile(X,[1,K]),[m,K,n])
distances=tf.reduce_sum(tf.square(X_mat-centroids_mat),reduction_indices=2)
centroids_index=tf.argmin(distances,1)
total_sum=tf.unsorted_segment_sum(X,centroids_index,K)
num_total=tf.unsorted_segment_sum(tf.ones_like(X),centroids_index,K)
centroids=total_sum/num_total
for i in range(0,max_iter):
    print('iteration',i+1)
    sess.run(centroids)

centroids=np.array(sess.run(centroids),dtype=np.uint8)
centroids_index=np.array(sess.run(centroids_index),dtype=np.uint8)
centroids_index=np.reshape(centroids_index,[a,b],2)
np.save(path+'\codebook.npy',centroids)
cv2.imwrite(path+'\compressed.png',centroids_index)





