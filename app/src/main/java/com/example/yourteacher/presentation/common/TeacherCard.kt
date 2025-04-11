package com.example.yourteacher.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.yourteacher.R
import com.example.yourteacher.domain.model.TeacherUiModel
import com.example.yourteacher.presentation.Dimens.ExtraSmallPadding
import com.example.yourteacher.presentation.Dimens.ExtraSmallPadding2
import com.example.yourteacher.presentation.Dimens.SmallIconSize
import com.example.yourteacher.presentation.Dimens.TeacherCardSize
import com.example.yourteacher.ui.theme.YourTeacherTheme

@Composable
fun TeacherCard(
    modifier: Modifier = Modifier,
    teacher: TeacherUiModel,
    onClick: () -> Unit,
) {
    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(TeacherCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(LocalContext.current)
                .data(teacher.imageUrl)
                .crossfade(true)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .build(),
            contentDescription = "teacher image",
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(
                    TeacherCardSize
                )
        ) {
            Text(
                text = teacher.name,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(
                    id = R.color.text_title
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = teacher.subject,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(
                        id = R.color.body
                    )
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Text(
                    text = teacher.location,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(
                        id = R.color.body
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    YourTeacherTheme {
        TeacherCard(
            teacher = TeacherUiModel(
                id = "1",
                name = "Ahmad Saleh",
                subject = "Mathematics",
                grade = "10th Grade",
                price = "20 USD/hour",
                schedule = "Sat-Wed: 4PM - 6PM",
                location = "Gaza City",
                imageUrl = null
            )
        ) {}
    }
}













