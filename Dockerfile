# Use the official Nginx image
FROM nginx:latest

# Copy website files to the Nginx HTML folder
COPY index.html /usr/share/nginx/html/
COPY styles.css /usr/share/nginx/html/

# Expose port 80 for web traffic
EXPOSE 80

# Run Nginx
CMD ["nginx", "-g", "daemon off;"]
