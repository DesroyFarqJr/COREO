BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, videos, likes, comments, followers, favorites, hashtags, video_hashtags, analytics, challenges, challenge_videos, collaborations, filters, filter_videos, categories, interests, notifications;

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	email VARCHAR(100) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
	profile_picture VARCHAR(255),
	bio TEXT
);

CREATE TABLE videos (
	video_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	tags TEXT[],
	duration INTEGER NOT NULL,
	file_name VARCHAR(255) NOT NULL,
	thumbnail_name VARCHAR(255) NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE likes (
	like_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	video_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (video_id) REFERENCES videos(video_id)
);

CREATE TABLE comments (
	comment_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	video_id INTEGER NOT NULL,
	text TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (video_id) REFERENCES videos(video_id)
);

CREATE TABLE followers (
	follower_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	follower_user_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (follower_user_id) REFERENCES users(user_id)
);

CREATE TABLE favorites (
	favorite_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	video_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (video_id) REFERENCES videos(video_id)
);

CREATE TABLE hashtags (
	hashtag_id SERIAL PRIMARY KEY,
	text VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE video_hashtags (
	video_hashtag_id SERIAL PRIMARY KEY,
	video_id INTEGER NOT NULL,
	hashtag_id INTEGER NOT NULL,
	FOREIGN KEY (video_id) REFERENCES videos(video_id),
	FOREIGN KEY (hashtag_id) REFERENCES hashtags(hashtag_id)
);

CREATE TABLE analytics (
	analytics_id SERIAL PRIMARY KEY,
	video_id INTEGER NOT NULL,
	views INTEGER NOT NULL DEFAULT 0,
	likes INTEGER NOT NULL DEFAULT 0,
	comments INTEGER NOT NULL DEFAULT 0,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (video_id) REFERENCES videos(video_id)
);

CREATE TABLE challenges (
	challenge_id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE challenge_videos (
	challenge_video_id SERIAL PRIMARY KEY,
	video_id INTEGER NOT NULL,
	challenge_id INTEGER NOT NULL,
	FOREIGN KEY (video_id) REFERENCES videos(video_id),
	FOREIGN KEY (challenge_id) REFERENCES challenges(challenge_id)
);

CREATE TABLE collaborations (
	collaboration_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	collaborator_user_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (collaborator_user_id) REFERENCES users(user_id)
);

CREATE TABLE filters (
	filter_id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE filter_videos (
	filter_video_id SERIAL PRIMARY KEY,
	video_id INTEGER NOT NULL,
	filter_id INTEGER NOT NULL,
	FOREIGN KEY (video_id) REFERENCES videos(video_id),
	FOREIGN KEY (filter_id) REFERENCES filters(filter_id)
);

CREATE TABLE categories (
	category_id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT
);

CREATE TABLE interests (
interest_id SERIAL PRIMARY KEY,
user_id INTEGER NOT NULL,
category_id INTEGER NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(user_id),
FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE notifications (
notification_id SERIAL PRIMARY KEY,
user_id INTEGER NOT NULL,
notification_type VARCHAR(255) NOT NULL,
notification_text TEXT NOT NULL,
video_id INTEGER,
created_at TIMESTAMP DEFAULT NOW(),
FOREIGN KEY (user_id) REFERENCES users(user_id),
FOREIGN KEY (video_id) REFERENCES videos(video_id)
);


COMMIT TRANSACTION;
