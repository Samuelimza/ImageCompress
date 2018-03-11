import numpy as np
import tensorflow as tf
import random
import cv2


#loading the required data

X=np.loadtxt()
m,n=np.shape(X)
K=128     #the number of clusters to be formed
max_iter=500  #maximum number of iterations to be performed

#randomly initializing the centroids
centroids=np.zeros((K,n),np.float32)
for i in range(0,K):
    w=random.randint(0,m)
    centroids[i,:]=w

#initializing the required tensorflow tensors

X=tf.constant(X,tf.float32)
centroids=tf.Variable(centroids,tf.float32)
init=tf.global_variables_initializer()
sess=tf.Session()
sess.run(init)


#forming clusters

for i in range(0,max_iter):
    cenroids_mat=tf.reshape(tf.tile(centroids,[m,1]),[m,K,n])
    X_mat=tf.reshape(tf.tile(X,[1,K]),[m,K,n])
    distances=tf.reduce_sum(tf.square(X_mat-centroids_mat),reduction_indices=2)
    centroids_index=tf.argmin(distances,1)
    total_sum=tf.unsorted_segment_sum(X,centroids_index,K)
    num_total=tf.unsorted_segment_sum(tf.ones_like(X),centroids_index,K)
    centroids=total_sum/num_total

X=sess.run(X)
centroids=np.array(sess.run(centroids),dtype=np.uint8)
centroids_index=np.array(sess.run(centroids_index),dtype=np.uint8)
np.save('codebook_bird.npy',centroids)
cv2.imwrite('compressed_bird.png',centroids)
img=cv2.imread('compressed_bird.png',1)
cv2.imshow('disp',img)
cv2.waitKey(0)




